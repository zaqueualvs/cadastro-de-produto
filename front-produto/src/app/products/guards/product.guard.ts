import {ActivatedRouteSnapshot, ResolveFn, RouterStateSnapshot} from '@angular/router';
import {Observable, of} from "rxjs";
import {Product} from "../model/product";
import {ProductService} from "../services/product.service";
import {inject} from "@angular/core";

export const productResolver: ResolveFn<Product> =
  (route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Product> => {
    if (route.params && route.params['id']) {
      return inject(ProductService).loadById(route.params['id']);
    }
    return of({id: '', name: '', description: ''});
  };
