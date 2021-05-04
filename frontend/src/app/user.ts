import {Product} from "./product";

export class User {
  username: string;
  email: string;
  password: string;
  retypedPassword: string;
  cart: Array<Product>


  constructor(name: string, email: string, password: string) {
    this.username = name;
    this.email = email;
    this.password = password;
  }
}
