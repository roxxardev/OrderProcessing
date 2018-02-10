import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "./employee.service";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  rows: any[];
  columns: any[];

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.employeeService.getEmployees(0, 1000)
      .subscribe(value => {
        this.rows = value.content;
      });

    this.columns = [
      {prop: "id", name: "ID", width: 10},
      {prop: "firstName", name: "First name"},
      {prop: "lastName", name: "Last name"},
      {prop: "address", name: "Address"},
      {prop: "city", name: "City"},
      {prop: "country", name: "Country"},
      {prop: "homePhone", name: "Phone"},
      {prop: "title", name: "Title"},
      {prop: "notes", name: "Notes", width: 400}
    ];
  }

}
