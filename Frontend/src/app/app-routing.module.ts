import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {ListStudentComponent} from './list-student/list-student.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';
import { ShowStudentComponent } from './show-student/show-student.component';
import { RoomStudentComponent } from './room-student/room-student.component';
import { ShowRoomComponent } from './show-room/show-room.component';
import { SubjectStudentComponent } from './subject-student/subject-student.component';
import { SubjectListComponent } from './subject-list/subject-list.component';
import { SubjectShowComponent } from './subject-show/subject-show.component';
import { ImageComponent } from './image/image.component';


const routes: Routes = [
  { path: '', component:ListStudentComponent },
  { path: 'student/create', component:CreateStudentComponent},
  { path: 'student/edit/:id', component:EditStudentComponent},
  { path: 'student/show/:id', component:ShowStudentComponent},
  { path: 'class', component:RoomStudentComponent},
  { path: 'class/show/:id', component:ShowRoomComponent},
  { path: 'student/subject/:id', component:SubjectStudentComponent},
  { path: 'subject', component:SubjectListComponent},
  { path: 'subject/show/:id', component:SubjectShowComponent},
  { path: 'image', component:ImageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
