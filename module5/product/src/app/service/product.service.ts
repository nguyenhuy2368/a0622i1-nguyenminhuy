import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private PRODUCT_API = 'http://localhost:3000/product';

  constructor(private httpClient: HttpClient) {
  }

  products: Product[] = [];

  findAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(
      this.PRODUCT_API);
  }

  saveProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(this.PRODUCT_API, product);
  }

  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${(this.PRODUCT_API)}/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    return this.httpClient.put<Product>(`${(this.PRODUCT_API)}/${id}`, product);
  }

  deleteProduct(id: number) {
    return this.httpClient.delete<Product>(`${(this.PRODUCT_API)}/${id}`);
  }
}
