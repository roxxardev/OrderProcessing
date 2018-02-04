import {NgModule} from "@angular/core";
import {LoginComponent} from "./login/login.component";
import {RouterModule, Routes} from "@angular/router";

const authRoutes: Routes = [
  {path: 'login', component: LoginComponent},
];

@NgModule({
  imports: [
    RouterModule.forChild(authRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AuthRoutingModule {

}
