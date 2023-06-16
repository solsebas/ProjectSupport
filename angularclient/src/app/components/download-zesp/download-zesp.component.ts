import { Component } from '@angular/core';
import {Team} from "../../models/team";
import {TeamService} from "../../services/team/team.service";
import {DownloadZespServiceService} from "../../services/download-zesp-service.service";
import {first} from "rxjs";

@Component({
  selector: 'app-student-team',
  templateUrl: './download-zesp.component.html',
  styleUrls: ['./download-zesp.component.scss']
})
export class DownloadZespComponent {
  teams: Team[] = []
  topicNameFilter: string = '';
  idFilter: string = '';
  termFilter: string = '';
  statusFilter: string = '';
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


  protected readonly first = first;
}
