import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class OrderService {

  constructor(private http: HttpClient) { }

  getOrders(page:number, size: number): Observable<any> {
    let httpParams: HttpParams = new HttpParams();
    httpParams = httpParams.append('page', page.toString());
    httpParams = httpParams.append('size', size.toString());
    return this.http.get('/api/orders', {params: httpParams});
  }

  getOrdersStats(): Observable<any> {
    return this.http.get("/api/orders/countryStatistics");
  }
}
