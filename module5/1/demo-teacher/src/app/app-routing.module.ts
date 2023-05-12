import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TeacherComponent} from './component/teacher/teacher.component';
import {TeacherEditComponent} from './component/teacher-edit/teacher-edit.component';
import {TeacherCreateComponent} from './component/teacher-create/teacher-create.component';


const routes: Routes = [
  {path: 'teacher', component: TeacherComponent},
  {path: 'teacher/create', component: TeacherCreateComponent},
  {path: 'teacher/edit/:id', component: TeacherEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
