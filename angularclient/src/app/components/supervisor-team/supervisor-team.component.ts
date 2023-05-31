import { Component } from '@angular/core';
import {Team} from "../../models/team";
import {TeamService} from "../../services/team/team.service";

@Component({
  selector: 'app-supervisor-team',
  templateUrl: './supervisor-team.component.html',
  styleUrls: ['./supervisor-team.component.scss']
})
export class SupervisorTeamComponent {
  teams: Team[] = []
  topicNameFilter: string = '';
  idFilter: string = '';
  termFilter: string = '';
  statusFilter: string = '';
  constructor(private teamService: TeamService) {

    this.teamService.getSupervisorTeams().subscribe({
      next: data => {
        this.teams = data;
      },
      error: err => {
        console.error(err);
      }
    });
  }

}
