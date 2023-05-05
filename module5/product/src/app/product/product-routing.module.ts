import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductComponent} from './product/product.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductEditComponent} from './product-edit/product-edit.component';
import {ProductDeleteComponent} from './product-delete/product-delete.component';


const routes: Routes = [
  {
    path: 'list',
    component: ProductComponent
  }, {
    path: 'create',
    component: ProductCreateComponent
  }, {
    path: 'edit/:id',
    component: ProductEditComponent
  }, {
    path: 'delete/:id',
    component: ProductDeleteComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
