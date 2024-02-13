import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly API = 'products';

  constructor(private httpCliente: HttpClient) {

  }

  list(page = 0, pageSize = 5) {
    return this.httpCliente.get<Product[]>(this.API, {params : {page, pageSize}})
  }
}
