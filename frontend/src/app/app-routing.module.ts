import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./core/home/home.component";
import {AuthGuardService} from "./auth/auth-guard.service";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {OrdersDashboardComponent} from "./dashboard/orders-dashboard/orders-dashboard.component";
import {ProductsDashboardComponent} from "./dashboard/products-dashboard/products-dashboard.component";
import {OrdersComponent} from "./orders/orders.component";
import {ProductsComponent} from "./products/products.component";
import {EmployeesComponent} from "./employees/employees.component";
import {CustomersComponent} from "./customers/customers.component";
import {OrderDetailsComponent} from "./orders/order-details/order-details.component";

const appRoutes: Routes = [
  {path: '', redirectTo: "home", pathMatch: 'full'},
  {
    path: 'home', component: HomeComponent,
    canActivate: [AuthGuardService],
    children: [
      {
        path: '', redirectTo: "/home/dashboard/orders", pathMatch: 'full'
      },
      {
        path: 'dashboard',
        component: DashboardComponent,
        children: [
          {path: '', redirectTo: "/home/dashboard/orders", pathMatch: 'full'},
          {path: 'orders', component: OrdersDashboardComponent},
          {path: 'products', component: ProductsDashboardComponent}
        ]
      },
      {
        path: 'orders',
        component: OrdersComponent,
        children: [
          {path: ':id', component: OrderDetailsComponent}
        ]
      },
      {path: 'products', component: ProductsComponent},
      {path: 'employees', component: EmployeesComponent},
      {path: 'customers', component: CustomersComponent},
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes, {preloadingStrategy: PreloadAllModules})
  ],
  exports: [
    RouterModule
  ],
  providers: [
    AuthGuardService
  ]
})
export class AppRoutingModule {
}
