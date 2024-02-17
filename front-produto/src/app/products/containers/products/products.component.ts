import {Component, OnInit, ViewChild} from '@angular/core';
import {MatToolbar} from "@angular/material/toolbar";
import {ProductsListComponent} from "../../components/products-list/products-list.component";
import {MatCard} from "@angular/material/card";
import {Observable, tap} from "rxjs";
import {ProductPage} from "../../model/product-page";
import {MatPaginator, MatPaginatorIntl, PageEvent} from "@angular/material/paginator";
import {ProductService} from "../../services/product.service";
import {AsyncPipe} from "@angular/common";
import {MatProgressSpinner} from "@angular/material/progress-spinner";
import {Product} from "../../model/product";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [
    MatToolbar,
    ProductsListComponent,
    MatCard,
    AsyncPipe,
    MatProgressSpinner,
    MatPaginator,
  ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss'
})
export class ProductsComponent {

  products$: Observable<ProductPage> | null = null
  @ViewChild(MatPaginator) paginator!: MatPaginator
  pageIndex = 0;
  pageSize = 5;

  constructor(
    private productService: ProductService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.refresh();
  }

  refresh(pageEvent: PageEvent = {length: 0, pageIndex: 0, pageSize: 5}) {
    this.products$ = this.productService.list(pageEvent.pageIndex, pageEvent.pageSize)
      .pipe(
        tap(() => {

          this.pageIndex = pageEvent.pageIndex;
          this.pageSize = pageEvent.pageSize;
        }),
      );
  }

  onAdd() {
    this.router.navigate(['new'], {relativeTo: this.route})
  }

  onEdit(product: Product) {
    this.router.navigate(['edit', product.id], {relativeTo: this.route});
  }

  onDelete(product: Product) {
    this.productService.delete(product.id).subscribe(
      () => this.refresh()
    );
  }

  onDetail(product: Product) {
    this.router.navigate(['detail', product.id], {relativeTo: this.route});
  }

}
