import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {User} from "./user";
import {UserService} from "./user.service";
import {NgModel} from "@angular/forms";
import {LocalStorageService} from "angular-2-local-storage";
import {ProductsComponent} from "./products/products.component";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [
    './app.component.css'
  ]
})
export class AppComponent implements OnInit{
  @ViewChild(ProductsComponent) productsComponent;
  key = 'menu';
  title = "Welcome | Food EZ";
  compNumber = 0;
  formUser: User;
  currentUser: User = null;

  constructor(private userService: UserService, private _localStorageService: LocalStorageService) {
  }

  ngOnInit(): void {
    this.currentUser = JSON.parse(this._localStorageService.get("current_user"));
  }

  public change_outlet(event: any) {
    if (event.hasOwnProperty('key') && event.hasOwnProperty('title'))
      switch (event.key) {
        case 'menu':
          this.compNumber = 0;
          break;
        case 'about-us':
          this.compNumber = 1;
          break;
        case 'products':
          this.compNumber = 2;
          break;
        case 'contact-us':
          this.compNumber = 3;
          break;
      }
    this.title = event['title'];
  }

  public onSubmitRegistration(name: NgModel, email: NgModel, password: NgModel, retypedPassword: NgModel) {
    if (password.viewModel == retypedPassword.viewModel) {
      this.formUser = new User(name.viewModel, email.viewModel, password.viewModel);
      this.userService.save(this.formUser);
    }
  }

  public onSubmitLogin(username_email: NgModel, password: NgModel) {
    const username_regex = new RegExp("^[A-Za-z0-9_]+$");
    const email_regex = new RegExp("^\\S+@\\S+\\.\\S+$");
    if (username_regex.test(username_email.viewModel)) {
      this.userService.login(username_email.viewModel, null, password.viewModel).subscribe((current: User) => {
        this.currentUser = current;
        this._localStorageService.set("current_user", JSON.stringify(current));
      });
    }
    if (email_regex.test(username_email.viewModel)) {
      this.userService.login(null, username_email.viewModel, password.viewModel).subscribe((current: User) => {
        this.currentUser = current;
        this._localStorageService.set("current_user", JSON.stringify(current));
      });
    }
    setTimeout(() => {
      console.log(this.currentUser);
    }, 1000);
  }

  public logout(){
    this._localStorageService.remove("current_user");
    this.currentUser = null;
  }

}
