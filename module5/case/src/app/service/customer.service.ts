import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private CUSTOMER_API = 'http://localhost:3000/customers';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.CUSTOMER_API);
  }

  // findById(id: number): Observable<Customer> {
  //   return this.httpClient.get<Customer>(`${this.CUSTOMER_API}/${id}`);
  // }
}
