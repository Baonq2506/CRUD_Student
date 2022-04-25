import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatButtonModule} from '@angular/material/button';
import {MatBadgeModule} from '@angular/material/badge';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { MatTableModule} from '@angular/material/table';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatFormFieldModule} from '@angular/material/form-field';

import { ListStudentComponent } from './list-student/list-student.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';
import { ShowStudentComponent } from './show-student/show-student.component';

import { HttpClientModule } from '@angular/common/http';
import {FormsModule } from '@angular/forms';
import { RoomStudentComponent } from './room-student/room-student.component';
import { ShowRoomComponent } from './show-room/show-room.component';
import { SubjectStudentComponent } from './subject-student/subject-student.component';
import { SubjectListComponent } from './subject-list/subject-list.component';
import { SubjectShowComponent } from './subject-show/subject-show.component';
import { ImageComponent } from './image/image.component';




@NgModule({
declarations: [
    AppComponent,
    ListStudentComponent,
    CreateStudentComponent,
    EditStudentComponent,
    ShowStudentComponent,
    RoomStudentComponent,
    ShowRoomComponent,
    SubjectStudentComponent,
    SubjectListComponent,
    SubjectShowComponent,
    ImageComponent,

],
imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatBadgeModule,
    MatTableModule,
    MatTooltipModule,
    FormsModule,
    HttpClientModule

],
providers: [],
bootstrap: [AppComponent]
})
export class AppModule { }
