import {Product} from "./product";

export interface ProductPage{
  products: Product[];
  totalElements: number;
  totalPage: number;
}
