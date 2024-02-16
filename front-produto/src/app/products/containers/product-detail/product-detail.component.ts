import {Component, OnInit} from '@angular/core';
import {MatCard} from "@angular/material/card";
import {MatToolbar} from "@angular/material/toolbar";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {Form, FormGroup, NonNullableFormBuilder, ReactiveFormsModule} from "@angular/forms";
import {Product} from "../../model/product";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [
    MatCard,
    MatToolbar,
    MatFormFieldModule,
    MatInput,
    ReactiveFormsModule
  ],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.scss'
})
export class ProductDetailComponent implements OnInit {
  form!: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: NonNullableFormBuilder
  ) {
  }

  ngOnInit(): void {
    const product: Product = this.route.snapshot.data['product'];
    this.form = this.formBuilder.group({
      name: [product.name],
      description: [product.description],
    })
  }
}
