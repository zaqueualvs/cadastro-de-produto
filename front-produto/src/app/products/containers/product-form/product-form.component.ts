import {Component, OnInit} from '@angular/core';
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {ActivatedRoute, Router} from "@angular/router";
import {FormGroup, NonNullableFormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {Product} from "../../model/product";
import {ProductService} from "../../services/product.service";
import {MatSnackBar} from "@angular/material/snack-bar";

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
    private service: ProductService,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    const product: Product = this.route.snapshot.data['product']
    this.form = this.formBuilder.group({
      id: [product.id],
      name: [product.name, [Validators.required, Validators.minLength(3)]],
      description: [product.description]
    })
  }

  onCancel() {
    this.router.navigate([''], {relativeTo: this.route})
  }

  onSubmit() {
    if (this.form.valid) {
      const id = this.form.value.id;
      this.form.removeControl('id')
      this.save(id, this.form.value).subscribe(
        result => this.onSuccess()
      )
    }
  }

  private save(id: string, product: Partial<Product>) {
    if (id) {
      return this.service.update(id, product)
    } else {
      return this.service.create(product)
    }
  }

  private onSuccess() {
    this.snackBar.open('Produto salvo com sucesso!', '', {duration: 5000});
    this.onCancel();
  }
}
