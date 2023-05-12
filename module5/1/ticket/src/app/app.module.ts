import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {HeaderComponent} from './component/layout/header/header.component';
import {TicketListComponent} from './component/ticket-list/ticket-list.component';
import {TicketCreateComponent} from './component/ticket-create/ticket-create.component';
import {TicketEditComponent} from './component/ticket-edit/ticket-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TicketListComponent,
    TicketCreateComponent,
    TicketEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
