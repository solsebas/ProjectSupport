import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {RegisterComponent} from "./components/register/register.component";
import {BoardStudentComponent} from "./components/board-user/board-student.component";
import {BoardAdminComponent} from "./components/board-admin/board-admin.component";
import {BoardSupervisorComponent} from "./components/board-supervisor/board-supervisor.component";
import {TopicFormComponent} from "./components/topic-form/topic-form.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'studentBoard', component: BoardStudentComponent },
  { path: 'supervisor', component: BoardSupervisorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'topic', component: TopicFormComponent},

  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
