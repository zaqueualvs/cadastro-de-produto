import {Component, Input} from '@angular/core';
import {Product} from "../../model/product";
import {MatPaginator} from "@angular/material/paginator";
import {MatHeaderRow, MatRow, MatTable, MatTableModule} from "@angular/material/table";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";

@Component({
  selector: 'app-products-list',
  standalone: true,
  imports: [
    MatPaginator,
    MatTable,
    MatHeaderRow,
    MatRow,
    MatTableModule,
    MatButtonModule,
    MatIconModule

  ],
  templateUrl: './products-list.component.html',
  styleUrl: './products-list.component.scss'
})
export class ProductsListComponent {
  @Input() products: Product[] = [];

  readonly displayedColumns = ['id', 'name', 'description', 'action'];

  onAdd() {
    console.log("add ")
  }
}
