import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
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

  constructor(private route: ActivatedRoute, private teamService :TeamService, private router: Router) {
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

  getStatusColor(status: string | undefined): string {
    if (status === 'CLOSED' || status === 'CANCELED') {
      return 'red';
    } else if (status === 'ACTIVE') {
      return 'blue';
    } else if (status === 'NEW') {
      return 'green';
    } else {
      return 'black'; // Kolor domyślny dla innych statusów
    }
  }

  navigateToStudentTeam() {
    this.router.navigateByUrl('/student/team');
  }

}
