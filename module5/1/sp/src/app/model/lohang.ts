import {ISanPham} from './sanpham';

export interface ILoHang {
  id: number;
  idLoHang: string;
  sanPham: ISanPham;
  soLuong: number;
  ngayNhapHang: string;
  ngaysanXuat: string;
  ngayHetHan: string;
}
