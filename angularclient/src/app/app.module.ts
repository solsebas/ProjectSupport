import {Injectable, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule } from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import { SideNavbarComponent } from './components/side-navbar/side-navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import {httpInterceptorProviders} from "./helpers/auth.interceptor";
import { RegisterComponent } from './components/register/register.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';
import { BoardStudentComponent } from './components/board-user/board-student.component';
import { BoardSupervisorComponent } from './components/board-supervisor/board-supervisor.component';
import { TopicFormComponent } from './components/topic-form/topic-form.component';
import { TeamFormComponent } from './components/team-form/team-form.component';
import { BlockUrlGuard } from './block-url.guard';
import { AccessDeniedComponent } from './components/access-denied/access-denied.component';


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
    BoardStudentComponent,
    BoardSupervisorComponent,
    TopicFormComponent,
    TeamFormComponent,
    AccessDeniedComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ httpInterceptorProviders, BlockUrlGuard ],
  bootstrap: [AppComponent]
})
export class AppModule { }
