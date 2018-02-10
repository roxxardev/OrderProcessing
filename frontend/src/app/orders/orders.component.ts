import { Component, OnInit } from '@angular/core';
import {OrderService} from "./order.service";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  rows: any[];
  columns: any[];

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.getOrders();

    this.columns = [
      {prop: "id", name: "Id"},
      {prop: "customerId", name: "Customer id"},
      {prop: "freight", name: "Freight"},
      {prop: "orderDate", name: "Order date"},
      {prop: "shippedDate", name: "Shipped date"},
      {prop: "requiredDate", name: "Required date"},
      {prop: "shipCountry", name: "Ship country"},
      {prop: "shipCity", name: "Ship city"}
    ];
  }

  getOrders() {
    this.orderService.getOrders(0, 1000)
      .subscribe(value => {
        this.rows = value.content;
      });
  }
}
