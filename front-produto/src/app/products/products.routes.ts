import {Routes} from "@angular/router";
import {ProductsComponent} from "./containers/products/products.component";
import {ProductDetailComponent} from "./containers/product-detail/product-detail.component";
import {productResolver} from "./guards/product.guard";

export const PRODUCTS_ROUTES: Routes = [
  {path: '', component: ProductsComponent},
  {path: 'detail/:id', component: ProductDetailComponent, resolve: {product: productResolver}}

];
