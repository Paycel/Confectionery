import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {UserListComponent} from './user-list/user-list.component';
import {AboutUsComponent} from "./about-us/about-us.component";
import {MenuComponent} from "./menu/menu.component";
import {ProductsComponent} from "./products/products.component";
import {ContactUsComponent} from "./contact-us/contact-us.component";
import {ProductDetailsComponent} from "./product-details/product-details.component";
import {CartComponent} from "./cart/cart.component";

const routes: Routes = [
  {path: '', component: MenuComponent},
  {path: 'contact-us', component: ContactUsComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'users', component: UserListComponent},
  {path: 'product-details', component: ProductDetailsComponent},
  {path: 'cart', component: CartComponent},
  {path: 'about-us', component: AboutUsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
