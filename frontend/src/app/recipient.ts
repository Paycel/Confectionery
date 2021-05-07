import {Product} from "./product";

export class Recipient{
  firstName: string;
  lastName: string;
  email: string;
  phoneNumber: string;
  city: string;
  address: string;
  instructions: string;
  productList: Array<Product>;

  constructor() {
  }
}
