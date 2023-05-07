import { Component } from '@angular/core';
import {Team} from "../../models/team";
import {TeamService} from "../../services/team.service";

@Component({
  selector: 'app-team-form',
  templateUrl: './team-form.component.html',
  styleUrls: ['./team-form.component.scss']
})
export class TeamFormComponent {
  showFormViewTeams = false;
  showTeamsList = false;

  teams: Team[] = [];

  constructor(private teamService: TeamService) {
    this.teamService.getTeam().subscribe({
      next: data => {
        this.teams = data;
      },
      error: err => {
        console.error(err);
      }
    });
  }

  openForViewTeam() {
    this.showTeams();
    this.showFormViewTeams = true;
  }

  closeFormViewTeam(){
    this.showFormViewTeams = false;
  }

  showTeams(){
    this.showTeamsList = true;
    this.teamService.getTeam().subscribe({
      next: data => {
        console.log(data);
        this.teams = data;
      },
      error: err => {
        console.error(err);
      }
    })
  }
}
