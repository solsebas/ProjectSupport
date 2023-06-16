import { Injectable, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { SideNavbarComponent } from './components/side-navbar/side-navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { httpInterceptorProviders } from "./helpers/auth.interceptor";
import { RegisterComponent } from './components/register/register.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';
import { BoardSupervisorComponent } from './components/board-supervisor/board-supervisor.component';
import { TopicFormComponent } from './components/topic-form/topic-form.component';
import { TeamFormComponent } from './components/team-form/team-form.component';
import { BlockUrlGuard } from './block-url.guard';
import { AccessDeniedComponent } from './components/access-denied/access-denied.component';
import { StudentTeamComponent } from "./components/student-team/student-team.component";
import { StudentsTeamBoardComponent } from './components/student-team/students-team-board/students-team-board.component';
import { SupervisorTeamComponent } from './components/supervisor-team/supervisor-team.component';
import { SupervisorTeamBoardComponent } from './components/supervisor-team/supervisor-team-board/supervisor-team-board.component';
import { FilterPipe } from "./helpers/filter.pipe";
import {DownloadUploaddComponent} from "./components/download-upload/download-upload.component";
import { DownloadZespComponent } from './components/download-zesp/download-zesp.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SideNavbarComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    ProfileComponent,
    RegisterComponent,
    BoardAdminComponent,
    BoardSupervisorComponent,
    TopicFormComponent,
    TeamFormComponent,
    AccessDeniedComponent,
    StudentTeamComponent,
    StudentsTeamBoardComponent,
    SupervisorTeamComponent,
    SupervisorTeamBoardComponent,
    FilterPipe,
    DownloadUploaddComponent,
    DownloadZespComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders, BlockUrlGuard],
  exports: [
    FilterPipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
