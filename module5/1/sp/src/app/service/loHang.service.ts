import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ILoHang} from "../model/lohang";
import {ISanPham} from "../model/sanpham";

@Injectable({
  providedIn: 'root'
})
export class LoHangService {

  constructor(
    private httpClient:HttpClient
  ) { }
  getAllEntity():Observable<ILoHang[]>{
    return this.httpClient.get<ILoHang[]>('http://localhost:3000/lohangs')
  }
  getAllSanPham():Observable<ISanPham[]>{
    return this.httpClient.get<ISanPham[]>('http://localhost:3000/sanphams')
  }
  saveLoHang(lohang:ILoHang):Observable<ILoHang>{
    return this.httpClient.post<ILoHang>('http://localhost:3000/lohangs',lohang)
  }
  deleteLoHang(lohang:ILoHang):Observable<ILoHang>{
    return this.httpClient.delete<ILoHang>('http://localhost:3000/lohangs/'+ lohang.id)
  }
  searchByName(name:any):Observable<ILoHang[]>{
    return this.httpClient.get<ILoHang[]>('http://localhost:3000/lohangs?sanPham.ten_like='+name)
  }
  searchByNHH(ngayhethan:any):Observable<ILoHang[]>{
    return this.httpClient.get<ILoHang[]>('http://localhost:3000/lohangs?ngayHetHan='+ngayhethan)
  }
}
