import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {CustomerService} from "./customer.service";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CustomersComponent implements OnInit {
  isLoading: boolean = false;
  columns: any[];
  rows: any[];
  pageSize: number = 15;
  currentPage: number = -1;
  totalPages: number;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit() {
    this.columns = [
      {prop: "id", name: "Id", width: 100},
      {prop: "contactName", name: "Contact name"},
      {prop: "companyName", name: "Company name"},
      {prop: "address", name: "Address"},
      {prop: "city", name: "City"},
      {prop: "country", name: "Country"},
      {prop: "fax", name: "Fax"},
      {prop: "phone", name: "Phone"}
    ];

    this.getCustomers();
  }

  getCustomers() {
    if (!this.isLoading) {
      if(this.currentPage >= this.totalPages) {
        return;
      }
      this.isLoading = true;
      this.customerService.getCustomers(++this.currentPage, this.pageSize).subscribe(value => {
        if (this.rows == null) {
          this.rows = value.content;
        } else {
          this.rows = this.rows.concat(value.content);
        }
        this.totalPages = value.totalPages;
        this.isLoading = false;
      })
    }
  }
}
