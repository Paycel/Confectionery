export class User {
  username: string;
  email: string;
  password: string;
  retypedPassword: string;


  constructor(name: string, email: string, password: string) {
    this.username = name;
    this.email = email;
    this.password = password;
  }
}
