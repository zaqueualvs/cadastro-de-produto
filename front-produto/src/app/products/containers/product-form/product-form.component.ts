import {Component, OnInit} from '@angular/core';
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {ActivatedRoute, Router} from "@angular/router";
import {FormGroup, NonNullableFormBuilder, ReactiveFormsModule} from "@angular/forms";
import {Product} from "../../model/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [
    MatCardModule,
    MatFormFieldModule,
    MatIconModule,
    MatToolbarModule,
    MatInputModule,
    MatButtonModule,
    ReactiveFormsModule
  ],
  templateUrl: './product-form.component.html',
  styleUrl: './product-form.component.scss'
})
export class ProductFormComponent implements OnInit {

  form!: FormGroup

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: NonNullableFormBuilder,
    private service: ProductService
  ) {
  }

  ngOnInit(): void {
    const product: Product = this.route.snapshot.data['product']
    this.form = this.formBuilder.group({
      name: [product.name],
      description: [product.description]
    })
  }

  onCancel() {
    this.router.navigate([''], {relativeTo: this.route})
  }

  onSubmit() {
    if (this.form) {
      this.service.save(this.form.value).subscribe()
    }
  }
}
