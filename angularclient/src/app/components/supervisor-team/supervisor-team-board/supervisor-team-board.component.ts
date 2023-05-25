import { Component } from '@angular/core';
import {TeamMember} from "../../../models/team-member";
import {ActivatedRoute} from "@angular/router";
import {TeamService} from "../../../services/team/team.service";
import {Subscription} from "rxjs";
import {Team} from "../../../models/team";

@Component({
  selector: 'app-supervisor-team-board',
  templateUrl: './supervisor-team-board.component.html',
  styleUrls: ['./supervisor-team-board.component.scss']
})
export class SupervisorTeamBoardComponent {
  selectedId: number = 0;
  members: TeamMember[] = [];

  constructor(private route: ActivatedRoute, private teamService :TeamService) {
    const sub: Subscription =
      this.route.params.subscribe(params => {
        this.selectedId = params['id'];
      });
    const sub2: Subscription =
      this.teamService.getTeamMembers(this.selectedId).subscribe({
        next: data => {
          console.log(data);
          this.members = data;
        },
        error: err => {
          console.error(err);
        }
      });
  }
}
