import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {Ss3AngularOverviewModule} from './ss3-angular-overview/ss3-angular-overview.module';
import {Ss4Module} from './ss4/ss4.module';
import {RouterModule} from '@angular/router';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Ss3AngularOverviewModule,
    Ss4Module,
    RouterModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }