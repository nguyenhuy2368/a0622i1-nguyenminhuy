import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  message: string;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.productService.findAll().subscribe(
      data => {
        this.products = data;
      }, error => {
        this.message = 'That bai';
      }, () => {
        console.log('ket thuc');
      }
    );
  }
}
