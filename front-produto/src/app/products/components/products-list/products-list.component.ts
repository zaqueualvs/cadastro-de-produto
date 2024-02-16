import {Component, Input, Output, EventEmitter} from '@angular/core';
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
    MatIconModule,
    MatButtonModule

  ],
  templateUrl: './products-list.component.html',
  styleUrl: './products-list.component.scss'
})
export class ProductsListComponent {
  @Input() products: Product[] = [];
  @Output() add: EventEmitter<any> = new EventEmitter(false)
  @Output() detail: EventEmitter<Product> = new EventEmitter(false)
  @Output() edit: EventEmitter<Product> = new EventEmitter(false)
  @Output() remove: EventEmitter<Product> = new EventEmitter(false)

  readonly displayedColumns = ['id', 'name', 'description', 'action'];

  onAdd() {
    this.add.emit(false);
  }

  onEdit(product: Product) {
    this.edit.emit(product);
  }

  onDelete(product: Product) {
    this.remove.emit(product);
  }

  onDetail(product: Product) {
    this.detail.emit(product);
  }
}
