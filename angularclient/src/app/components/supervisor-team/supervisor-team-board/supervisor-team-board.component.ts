import { Component } from '@angular/core';
import {TeamMember} from "../../../models/team-member";
import {ActivatedRoute, Router} from "@angular/router";
import {TeamService} from "../../../services/team/team.service";
import {Subscription} from "rxjs";
import {Attendance} from "../../../models/attendance";
import {AttendanceService} from "../../../services/attendance/attendance.service";

@Component({
  selector: 'app-supervisor-team-board',
  templateUrl: './supervisor-team-board.component.html',
  styleUrls: ['./supervisor-team-board.component.scss']
})
export class SupervisorTeamBoardComponent {
  selectedId: number = 0;
  members: TeamMember[] = [];

  messageAdd: string = "";
  messageAddAttendacne: string = "";
  graded_id: bigint = BigInt(0);
  grade: number = 5;

  attendant_id: bigint = BigInt(0);
  date: string = '';
  attendance: boolean = false;

  constructor(private route: ActivatedRoute, private teamService :TeamService, private attendanceService: AttendanceService, private router: Router) {
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
    let member = this.getMember(this.graded_id)
    if (member) member.grade = this.grade
      // @ts-ignore
    this.teamService.addGrade(member).subscribe({
        next: data => {
          this.messageAdd = "Ocena " + member?.grade + " została ustawiona dla studenta " + member?.student.firstName + " " + member?.student.surname;
          this.graded_id = BigInt(0);
        },
        error: err => {
          console.error(err);
          this.messageAdd = err.toString();
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

  submitAttendanceForm(event: Event) {
    event.preventDefault();
    let member = this.getMember(this.attendant_id)
    if (member) {
      let attendance = new Attendance(this.attendance, this.date, this.attendant_id)
      // @ts-ignore
      this.attendanceService.createAttendance(attendance).subscribe({
        next: data => {
          if (this.attendance)
            this.messageAddAttendacne = "Obeconść w dniu " + this.date.toString() + " została dodana." ;
          else
            this.messageAddAttendacne = "Nieobeconść w dniu " + this.date.toString() + " została dodana." ;

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

        },
        error: err => {
          console.error(err);
          this.messageAddAttendacne = err.toString();
        }
      });
    }
  }



  getMember(id: bigint){
    for (let mem of this.members){
      if (mem.id == id){
        return mem
      }
    }
    return ;
  }

  editStatus(status: string){
    let team = this.members.at(0)?.team
    if (team){
      team.status = status
      this.teamService.setStatus(team).subscribe({
        next: data => {

        },
        error: err => {
          console.error(err);
        }
      })
    }
  }

  navigateToSupervisorTeamMengage() {
    this.router.navigateByUrl('/supervisor/team-manage');
  }
}
