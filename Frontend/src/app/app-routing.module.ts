import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {ListStudentComponent} from './list-student/list-student.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';
import { ShowStudentComponent } from './show-student/show-student.component';


const routes: Routes = [
  { path: '', component:ListStudentComponent },
  { path: 'student/create', component:CreateStudentComponent},
  { path: 'student/edit/:id', component:EditStudentComponent},
  { path: 'student/show/:id', component:ShowStudentComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
