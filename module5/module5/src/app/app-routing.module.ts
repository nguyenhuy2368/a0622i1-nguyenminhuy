import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MaytinhDongianComponent} from './ss3-angular-overview/maytinh-dongian/maytinh-dongian.component';
import {ColorPickerComponent} from './ss3-angular-overview/color-picker/color-picker.component';


const routes: Routes = [
  {path: 'ss3/b1', component: MaytinhDongianComponent},
  {path: 'ss3/b2', component: ColorPickerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
