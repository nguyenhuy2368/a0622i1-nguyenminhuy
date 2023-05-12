import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private CATEGORY_API = 'http://localhost:3000/categorys';

  constructor(private httpClient: HttpClient) {
  }
  findAll(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.CATEGORY_API);
  }

  saveCategory(category: Category): Observable<Category> {
    return this.httpClient.post<Category>(this.CATEGORY_API, category);
  }

  findById(id: number): Observable<Category> {
    return this.httpClient.get<Category>(`${this.CATEGORY_API}/${id}`);
  }

  updateCategory(id: number, category: Category): Observable<Category> {
    return this.httpClient.put<Category>(`${this.CATEGORY_API}/${id}`, category);
  }

  deleteCategory(id: number) {
    return this.httpClient.delete<Category>(`${this.CATEGORY_API}/${id}`);
  }
}
