import { Component } from '@angular/core';
import {Team} from "../../models/team";
import {TeamService} from "../../services/team/team.service";

@Component({
  selector: 'app-student-team',
  templateUrl: './student-team.component.html',
  styleUrls: ['./student-team.component.scss']
})
export class StudentTeamComponent {
  teams: Team[] = []

  constructor(private teamService: TeamService) {

    this.teamService.getStudentsTeams().subscribe({
      next: data => {
        this.teams = data;
      },
      error: err => {
        console.error(err);
      }
    });
  }
}
