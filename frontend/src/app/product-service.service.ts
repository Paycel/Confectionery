import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Subject} from "rxjs";
import {Product} from "./product";
import {Category} from "./category";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsUrl: string;
  private categoriesUrl: string;

  constructor(private http: HttpClient) {
    this.productsUrl = 'http://localhost:8080/products';
    this.categoriesUrl = "http://localhost:8080/categories";
  }

  public getProducts() {
    let products: Array<Product>;
    var subject = new Subject<Array<Product>>();
    this.getData(this.productsUrl, null).subscribe((current: Array<Product>) => {
      products = current;
      subject.next(products);
    });
    return subject.asObservable();
  }

  public getCategories() {
    let categories: Array<Category>;
    var subject = new Subject<Array<Category>>();
    this.getData(this.categoriesUrl, null).subscribe((current: Array<Category>) => {
      categories = current;
      subject.next(categories);
    });
    return subject.asObservable();
  }

  public getData(url, params: HttpParams) {
    return this.http.get(url, {params});
  }
}
