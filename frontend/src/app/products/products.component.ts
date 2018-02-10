import { Component, OnInit } from '@angular/core';
import {ProductService} from "./product.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  rows: any[];
  columns: any[];

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.getProducts(0, 1000)
      .subscribe(value => {
        this.rows = value.content;
      });

    this.columns = [
      {prop: "id", name: "Id", width: 10},
      {prop: "productName", name: "Product name", width: 300},
      {prop: "quantityPerUnit", name: "Quantity per unit", width: 200},
      {prop: "reorderLevel", name: "Reorder level"},
      {prop: "unitPrice", name: "Unit price"},
      {prop: "unitsInStock", name: "Units in stock"},
      {prop: "unitsOnOrder", name: "Units on order"},
      {prop: "discontinued", name: "Discontinued", width: 120}
    ];
  }

}
