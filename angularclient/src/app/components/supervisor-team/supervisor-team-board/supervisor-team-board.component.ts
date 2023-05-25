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

  graded_id: bigint = BigInt(0);
  grade: number = 5;

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


  submitGradeForm(event: Event) {
    event.preventDefault();
    // if(this.graded) this.graded.grade = this.grade
    let graded = this.getGraded(this.graded_id)
    if (graded) graded.grade = this.grade
      // @ts-ignore
    this.teamService.addGrade(graded).subscribe({
        next: data => {

        },
        error: err => {
          console.error(err);
        }
      });

  }

  getGraded(id: bigint){
    for (let mem of this.members){
      if (mem.id == id){
        return mem
      }
    }
    return ;
  }
}
