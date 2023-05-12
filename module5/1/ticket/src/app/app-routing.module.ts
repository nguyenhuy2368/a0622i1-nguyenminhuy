import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TicketListComponent} from './component/ticket-list/ticket-list.component';
import {TicketEditComponent} from './component/ticket-edit/ticket-edit.component';
import {TicketCreateComponent} from './component/ticket-create/ticket-create.component';


const routes: Routes = [
  {path: 'ticket', component: TicketListComponent},
  {path: 'ticket/create', component: TicketCreateComponent},
  {path: 'ticket/edit/:id', component: TicketEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
