import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../orders/order.service";

@Component({
  selector: 'app-orders-dashboard',
  templateUrl: './orders-dashboard.component.html',
  styleUrls: ['./orders-dashboard.component.css']
})
export class OrdersDashboardComponent implements OnInit {

  public data = [];
  public colorScheme = {domain: ['#1f1835', '#a10a28', '#23a122', '#c9b420']};

  constructor(private orderService: OrderService) {
  }

  ngOnInit() {
    this.orderService.getOrdersStats().subscribe(value => {
      this.data = value;
    })
  }

}
