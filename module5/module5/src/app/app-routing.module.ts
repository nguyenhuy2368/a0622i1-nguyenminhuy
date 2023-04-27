import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {MaytinhDongianComponent} from './ss3-angular-overview/maytinh-dongian/maytinh-dongian.component';
import {ColorPickerComponent} from './ss3-angular-overview/color-picker/color-picker.component';
import {ArticleComponent} from './ss4/article/article.component';
import {CountdownTimerComponent} from './ss5/countdown-timer/countdown-timer.component';
import {DictionayPageComponentComponent} from './ss7/dictionay-page-component/dictionay-page-component.component';
import {DictionaryDetailComponentComponent} from './ss7/dictionary-detail-component/dictionary-detail-component.component';




const routes: Routes = [
  {path: 'ss3/b1', component: MaytinhDongianComponent},
  {path: 'ss3/b2', component: ColorPickerComponent},
  {path: 'ss4', component: ArticleComponent},
  {path: 'ss5', component: CountdownTimerComponent},
  {path: 'ss7', component: DictionayPageComponentComponent},
  {path: 'ss7/detail/:index', component: DictionaryDetailComponentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
