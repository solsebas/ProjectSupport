import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {RegisterComponent} from "./components/register/register.component";
import {BoardAdminComponent} from "./components/board-admin/board-admin.component";
import {BoardSupervisorComponent} from "./components/board-supervisor/board-supervisor.component";
import {TopicFormComponent} from "./components/topic-form/topic-form.component";
import {TeamFormComponent} from "./components/team-form/team-form.component";
import {AccessDeniedComponent} from "./components/access-denied/access-denied.component";
import {BlockUrlGuard} from './block-url.guard'
import {StudentTeamComponent} from "./components/student-team/student-team.component";
import {StudentsTeamBoardComponent} from "./components/student-team/students-team-board/students-team-board.component";
import {SupervisorTeamComponent} from "./components/supervisor-team/supervisor-team.component";
import {
  SupervisorTeamBoardComponent
} from "./components/supervisor-team/supervisor-team-board/supervisor-team-board.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'access-denied', component: AccessDeniedComponent},
  { path: 'profile', component: ProfileComponent, canActivate: [BlockUrlGuard]  },

  { path: 'student/team', component: StudentTeamComponent, canActivate: [BlockUrlGuard]},
  { path: 'student/team/:id', component: StudentsTeamBoardComponent, canActivate: [BlockUrlGuard]},

  { path: 'admin', component: BoardAdminComponent, canActivate: [BlockUrlGuard]  },
  { path: 'admin/register', component: RegisterComponent, canActivate: [BlockUrlGuard]  },

  { path: 'supervisor', component: BoardSupervisorComponent, canActivate: [BlockUrlGuard]  },
  { path: 'supervisor/topic', component: TopicFormComponent, canActivate: [BlockUrlGuard] },
  { path: 'supervisor/team', component: TeamFormComponent, canActivate: [BlockUrlGuard] },
  { path: 'supervisor/team-manage', component: SupervisorTeamComponent, canActivate: [BlockUrlGuard]},
  { path: 'supervisor/team-manage/:id', component: SupervisorTeamBoardComponent, canActivate: [BlockUrlGuard]},


  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
