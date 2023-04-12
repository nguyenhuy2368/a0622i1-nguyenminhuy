import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {Ss3AngularOverviewModule} from './ss3-angular-overview/ss3-angular-overview.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Ss3AngularOverviewModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
