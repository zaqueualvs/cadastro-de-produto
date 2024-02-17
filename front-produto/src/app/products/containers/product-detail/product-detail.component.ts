import {Component, OnInit} from '@angular/core';
import {MatCard, MatCardModule} from "@angular/material/card";
import {MatToolbar} from "@angular/material/toolbar";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {NonNullableFormBuilder, ReactiveFormsModule} from "@angular/forms";
import {Product} from "../../model/product";
import {ActivatedRoute, Router} from "@angular/router";
import {MatButtonModule} from "@angular/material/button";
import {MatDivider} from "@angular/material/divider";

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [
    MatCard,
    MatToolbar,
    MatFormFieldModule,
    MatInput,
    ReactiveFormsModule,
    MatButtonModule,
    MatCardModule,
    MatDivider
  ],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.scss'
})
export class ProductDetailComponent implements OnInit {
  product! : Product

  constructor(
    private route: ActivatedRoute,
    private formBuilder: NonNullableFormBuilder,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.product = this.route.snapshot.data['product'];
  }

  backPage() {
    this.router.navigate([''], {relativeTo: this.route})
  }
}
