export class User {
  id: string;
  name: string;
  email: string;
  password: string;
  retypedPassword: string;


  constructor(name: string, email: string, password: string) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
