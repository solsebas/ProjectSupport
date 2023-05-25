import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Team} from "../../../models/team";
import {TeamService} from "../../../services/team/team.service";
import {TeamMember} from "../../../models/team-member";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-students-team-board',
  templateUrl: './students-team-board.component.html',
  styleUrls: ['./students-team-board.component.scss']
})
export class StudentsTeamBoardComponent {
  selectedId: number = 0;
  member: TeamMember | null = null;

  constructor(private route: ActivatedRoute, private teamService :TeamService) {
    const sub: Subscription =
    this.route.params.subscribe(params => {
      this.selectedId = params['id'];
    });
    const sub2: Subscription =
    this.teamService.getTeamMember(this.selectedId).subscribe({
      next: data => {
        console.log(data);
        this.member = data;
      },
      error: err => {
        console.error(err);
      }
    });
  }
}
