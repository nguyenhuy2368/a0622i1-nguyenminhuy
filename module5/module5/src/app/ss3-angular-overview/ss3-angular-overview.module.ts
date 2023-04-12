import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaytinhDongianComponent } from './maytinh-dongian/maytinh-dongian.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import {FormsModule} from '@angular/forms';



@NgModule({
    declarations: [MaytinhDongianComponent, ColorPickerComponent],
  exports: [
    ColorPickerComponent,
    MaytinhDongianComponent
  ],
    imports: [
        CommonModule,
        FormsModule
    ]
})
export class Ss3AngularOverviewModule { }
