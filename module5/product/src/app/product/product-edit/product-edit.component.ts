import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CategoryService} from '../../service/category.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  categories: Category[] = [];
  product: Product;
  id: number;

  equals(o1: Category, o2: Category) {
    return o1.id === o2.id;
  }

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private builder: FormBuilder,
              private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });

    this.getCategory();
  }

  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.product = product;
      this.productForm = this.builder.group({
        name: [product.name],
        price: [product.price],
        description: [product.description],
        category: [product.category]
      });
    });
  }

  updateProduct(id: number) {
    const product = this.productForm.value;
    this.productService.updateProduct(id, product).subscribe(() => {
      this.router.navigateByUrl('product/list');
    });
  }

  getCategory() {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    }, error => {
      console.log('Loi roi');
    }, () => {
      console.log('Xong roi');
    });
  }

  function(o1: any) {
    return undefined;
  }
}
