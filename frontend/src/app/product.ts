import {Category} from "./category";

export class Product {
  fullName: string;
  brandName: string;
  productName: string;
  price: number;
  amount: number;
  category: Category;
  url: string;


  constructor(fullName: string, brandName: string, productName: string, price: number, amount: number, category: Category, url: string) {
    this.fullName = fullName;
    this.brandName = brandName;
    this.productName = productName;
    this.price = price;
    this.amount = amount;
    this.category = category;
    this.url = url;
  }
}
