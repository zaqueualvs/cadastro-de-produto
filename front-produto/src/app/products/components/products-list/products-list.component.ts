import {Component, Input} from '@angular/core';
import {Product} from "../../model/product";

@Component({
  selector: 'app-products-list',
  standalone: true,
  imports: [],
  templateUrl: './products-list.component.html',
  styleUrl: './products-list.component.scss'
})
export class ProductsListComponent {
  @Input() products: Product[] = [];

  readonly displayedColumns = ['id', 'nome', 'descrição'];

}
