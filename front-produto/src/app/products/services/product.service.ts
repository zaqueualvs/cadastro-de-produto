import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../model/product";
import {ProductPage} from "../model/product-page";
import {tap} from "rxjs";
import {update} from "@angular-devkit/build-angular/src/tools/esbuild/angular/compilation/parallel-worker";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API = 'api/products';

  constructor(private httpClient: HttpClient) {

  }

  save(product: Partial<Product>) {
    if (product.id) {
      return this.update(product)
    } else {
      return this.create(product)
    }
  }

  list(page = 0, pageSize = 5) {
    return this.httpClient.get<ProductPage>(`${this.API}/page`, {params: {page, pageSize}})
  }

  loadById(id: string) {
    return this.httpClient.get<Product>(`${this.API}/${id}`)
  }

  update(product: Partial<Product>) {
    return this.httpClient.put<Product>(`${this.API}/${product.id}`, product)
  }

  delete(id: string) {
    return this.httpClient.delete(`${this.API}/${id}`)
  }

  create(product: Partial<Product>) {
    return this.httpClient.post<Product>(`${this.API}`, product)
  }
}
