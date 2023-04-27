import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DictionayPageComponentComponent } from './dictionay-page-component/dictionay-page-component.component';
import { DictionaryDetailComponentComponent } from './dictionary-detail-component/dictionary-detail-component.component';
import {RouterModule} from '@angular/router';



@NgModule({
  declarations: [ DictionayPageComponentComponent, DictionaryDetailComponentComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class Ss7Module { }
