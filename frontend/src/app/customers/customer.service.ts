import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class CustomerService {

  constructor(private http: HttpClient) { }

  getCustomers(page:number, size: number): Observable<any>{
    let httpParams: HttpParams = new HttpParams();
    httpParams = httpParams.append('page', page.toString());
    httpParams = httpParams.append('size', size.toString());
    return this.http.get('/api/customers', {params: httpParams});
  }
}
