import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {City} from '../model/city';
import {Category} from '../model/category';
import {House} from '../model/house';

@Injectable({
  providedIn: 'root'
})
export class HouseService {
  private API_HOUSE = 'http://localhost:3000/houses';
  private API_CITY = 'http://localhost:3000/citys';
  private API_CATEGORY = 'http://localhost:3000/categorys';

  constructor(private httpClient: HttpClient) {
  }

  getCityList(): Observable<City[]> {
    return this.httpClient.get<City[]>(this.API_CITY);
  }

  getCategoryList(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.API_CATEGORY);
  }

  findAll(): Observable<House[]> {
    return this.httpClient.get<House[]>(this.API_HOUSE);
  }

  save(house: House): Observable<void> {
    return this.httpClient.post<void>(this.API_HOUSE, house);
  }

  findById(id: number): Observable<House> {
    return this.httpClient.get<House>(this.API_HOUSE + '/' + id);
  }

  search(area: string, price: string, direction: string): Observable<House[]> {
    return this.httpClient.get<House[]>(this.API_HOUSE + '?area_gte=' + area + '&price_gte=' + price + '&direction_like=' + direction);
  }
}
