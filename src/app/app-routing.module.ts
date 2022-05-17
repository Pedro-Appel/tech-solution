import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";

import { Routes } from '@angular/router';
import { CreateProductComponent } from "./create-product/create-product.component";
import { LoginComponent } from "./login/login.component";
import { ProductTableComponent } from "./product-table/product-table.component";

export const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'productTable', component: ProductTableComponent},
  {path: 'novo', component: CreateProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
}
)
export class AppRoutingModule{

}
