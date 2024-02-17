import {Routes} from "@angular/router";
import {ProductsComponent} from "./containers/products/products.component";
import {ProductDetailComponent} from "./containers/product-detail/product-detail.component";
import {productResolver} from "./guards/product.guard";
import {ProductFormComponent} from "./containers/product-form/product-form.component";

export const PRODUCTS_ROUTES: Routes = [
  {path: '', component: ProductsComponent},
  {path: 'new', component: ProductFormComponent, resolve: {product: productResolver}},
  {path: 'edit/:id', component: ProductFormComponent, resolve: {product: productResolver}},
  {path: 'detail/:id', component: ProductDetailComponent, resolve: {product: productResolver}}

];
