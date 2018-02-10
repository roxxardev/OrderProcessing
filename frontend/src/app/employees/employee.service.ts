import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getEmployees(page:number, size: number): Observable<any> {
    let httpParams: HttpParams = new HttpParams();
    httpParams.append('page', page.toString());
    httpParams.append('size', size.toString());
    return this.http.get('/api/employees', {params: httpParams});
  }
}
