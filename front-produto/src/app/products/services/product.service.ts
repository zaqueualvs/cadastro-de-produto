import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../model/product";
import {ProductPage} from "../model/product-page";
import {tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API = 'api/products';

  constructor(private httpClient: HttpClient) {

  }

  list(page = 0, pageSize = 5) {
    return this.httpClient.get<ProductPage>(`${this.API}/page`, {params: {page, pageSize}})
  }
}
