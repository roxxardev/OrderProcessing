import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../products/product.service";

@Component({
  selector: 'app-products-dashboard',
  templateUrl: './products-dashboard.component.html',
  styleUrls: ['./products-dashboard.component.css']
})
export class ProductsDashboardComponent implements OnInit {

  public data = [];
  public colorScheme = {domain: ['#1f1835', '#a10a28', '#23a122', '#c9b420']};

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.productService.getProductsStatistics().subscribe(value => {
      this.data = value;
    })
  }

}
