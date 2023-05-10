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
import {TeamFormComponent} from "./components/team-form/team-form.component";
import {AccessDeniedComponent} from "./components/access-denied/access-denied.component";
import {BlockUrlGuard} from './block-url.guard'

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'profile', component: ProfileComponent, canActivate: [BlockUrlGuard]  },
  { path: 'studentBoard', component: BoardStudentComponent, canActivate: [BlockUrlGuard]  },
  { path: 'supervisor', component: BoardSupervisorComponent, canActivate: [BlockUrlGuard]  },
  { path: 'admin', component: BoardAdminComponent, canActivate: [BlockUrlGuard]  },
  { path: 'register', component: RegisterComponent, canActivate: [BlockUrlGuard]  },
  { path: 'topic', component: TopicFormComponent, canActivate: [BlockUrlGuard] },
  { path: 'team', component: TeamFormComponent, canActivate: [BlockUrlGuard] },
  { path: 'access-denied', component: AccessDeniedComponent},

  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
