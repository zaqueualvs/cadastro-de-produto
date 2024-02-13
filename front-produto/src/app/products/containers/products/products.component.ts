import {Component, OnInit} from '@angular/core';
import {MatToolbar} from "@angular/material/toolbar";
import {ProductsListComponent} from "../../components/products-list/products-list.component";
import {MatCard} from "@angular/material/card";
import {Observable, tap} from "rxjs";
import {ProductPage} from "../../model/product-page";
import {PageEvent} from "@angular/material/paginator";
import {ProductService} from "../../services/product.service";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [
    MatToolbar,
    ProductsListComponent,
    MatCard,
    AsyncPipe
  ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss'
})
export class ProductsComponent implements OnInit {

  products$: Observable<ProductPage> | null = null

  pageIndex = 0;
  pageSize = 5;

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
  }

  refresh(pageEvent: PageEvent = {length: 0, pageIndex: 0, pageSize: 5}) {
    this.products$ = this.productService.list(pageEvent.pageIndex, pageEvent.pageSize)
      .pipe(
        tap(() => {
          this.pageIndex = pageEvent.pageIndex;
          this.pageSize = pageEvent.pageSize;
        })
      );
  }

}
