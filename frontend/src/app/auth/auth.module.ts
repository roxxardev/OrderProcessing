import { NgModule } from '@angular/core';
import {LoginComponent} from "./login/login.component";
import {FormsModule} from "@angular/forms";
import {AuthRoutingModule} from "./auth-routing.module";
import {CommonModule} from "@angular/common";
import { LogoutComponent } from './logout/logout.component';

@NgModule({
  imports: [
    FormsModule,
    AuthRoutingModule,
    CommonModule
  ],
  declarations: [
    LoginComponent,
    LogoutComponent
  ]
})
export class AuthModule { }
