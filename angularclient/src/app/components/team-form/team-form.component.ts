import { Component } from '@angular/core';
import {Team} from "../../models/team";
import {TeamService} from "../../services/team/team.service";
import {Topic} from "../../models/topic";
import {Student} from "../../models/student";
import {StudentService} from "../../services/student/student.service";
import { Term } from "../../models/term";
import {TermService} from "../../services/term/term.service";
import {TopicService} from "../../services/topic/topic.service";

@Component({
  selector: 'app-team-form',
  templateUrl: './team-form.component.html',
  styleUrls: ['./team-form.component.scss']
})
export class TeamFormComponent {
  showFormViewTeams = false;
  showFormAddTeam = false;
  showTeamsList = false;
  showStudentList = false;

  terms: Term[] = [];
  supervisorTopics: Topic[] = [];
  selectedTerm: Term | null = null;
  selectedTopic: Topic | null = null;

  limit = 1;

  teams: Team[] = [];
  students: Student[] = [];

  teamId: bigint = BigInt(0);

  formTeamValid = false;
  formStudentValid = false;
  messageAdd = '';


  constructor(private teamService: TeamService, private studentService: StudentService, private termService: TermService, private topicService: TopicService ) {
    this.teamService.getTeams().subscribe({
      next: data => {
        this.teams = data;
      },
      error: err => {
        console.error(err);
      }
    });

    this.termService.getTerms().subscribe({
      next: data => {
        this.terms = data;
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

  openForAddTeam() {
    this.showFormAddTeam = true;
    this.topicService.getTopicsSupervisor().subscribe({
      next: data => {
        this.supervisorTopics = data;
      },
      error: err => {
        console.error(err);
      }
    });
  }

  closeFormAddTeam(){
    this.showFormAddTeam = false;
  }

  openForAddStudent(teamId: bigint) {
    this.teamId = teamId
    this.showStudents()
    this.showStudentList = true;
  }

  closeFormAddStudent(){
    this.showStudentList = false;
  }

  showStudents() {
    this.studentService.getStudents().subscribe({
      next: data => {
        console.log(data);
        this.students = data;
      },
      error: err => {
        console.error(err);
      }
    })
  }

  showTeams(){
    this.showTeamsList = true;
    this.teamService.getTeams().subscribe({
      next: data => {
        console.log(data);
        this.teams = data;
      },
      error: err => {
        console.error(err);
      }
    })
  }
  validateForm() {
    return this.formTeamValid = this.limit > 0 && this.limit < 7
  }

  submitTeamForm(event: Event) {
    event.preventDefault();

    if (this.selectedTerm && this.selectedTopic) {
      const team: Team = new Team(this.limit);
      team.term = this.selectedTerm;
      team.topic = this.selectedTopic;

      if (this.validateForm()) {
        this.teamService.createTeam(team).subscribe({
          next: data => {
            this.limit = 1;
            console.log(data);
            this.messageAdd = 'Zespół dodany poprawnie!';
            this.closeFormAddTeam();
          },
          error: err => {
            console.error(err);
            this.messageAdd = 'Błąd przy dodawaniu zespołu';
          }
        });
      }
    }
  }


  submitStudent(studentId: bigint){
    this.teamService.addStudent({'studentId': studentId, 'teamId': this.teamId}).subscribe({
      next: data => {
        this.teamId = BigInt(0);
        console.log(data);
        this.closeFormAddStudent();
      },
      error: err => {
        console.error(err);
      }
    });
  }


}
