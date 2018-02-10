import { NgModule } from '@angular/core';
import {HomeComponent} from "./home/home.component";
import {SharedModule} from "../shared/shared.module";
import {AppRoutingModule} from "../app-routing.module";
import { HeaderComponent } from './header/header.component';
import {AuthService} from "../auth/auth.service";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {AuthInterceptor} from "../auth/auth.interceptor";
import {AuthHelperService} from "../auth/auth-helper.service";
import {NgbCollapseModule} from "@ng-bootstrap/ng-bootstrap";
import {EmployeeService} from "../employees/employee.service";
import {ProductService} from "../products/product.service";
import {CustomerService} from "../customers/customer.service";
import {OrderService} from "../orders/order.service";

@NgModule({
  imports: [
    SharedModule,
    AppRoutingModule,
    NgbCollapseModule
  ],
  declarations: [
    HomeComponent,
    HeaderComponent
  ],
  exports: [
    AppRoutingModule,
    HeaderComponent
  ],
  providers: [
    AuthService,
    AuthHelperService,
    EmployeeService,
    ProductService,
    OrderService,
    CustomerService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true},
  ]
})
export class CoreModule { }
