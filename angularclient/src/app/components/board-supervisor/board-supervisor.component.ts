import {Component, HostListener, Injectable, OnInit} from '@angular/core';
import {UserService} from "../../services/user/user.service";
import {HttpClient} from "@angular/common/http";
import {Team} from "../../models/team";
import {Student} from "../../models/student";
import {TeamService} from "../../services/team/team.service";
import {StudentService} from "../../services/student/student.service";
import {Topic} from "../../models/topic";
import {TopicService} from "../../services/topic/topic.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-board-supervisor',
  templateUrl: './board-supervisor.component.html',
  styleUrls: ['./board-supervisor.component.scss']
})
export class BoardSupervisorComponent implements OnInit {
  showFormViewTeams = false;
  showFormAddTeam = false;
  showTeamsList = false;
  showStudentList = false;

  limit = 1;

  teams: Team[] = [];
  students: Student[] = [];

  teamId: bigint = BigInt(0);


  formTeamValid = false;
  formStudentValid = false;
  messageAddTeam = '';


  topicName = '';
  topicDescription = '';
  showFormAddTopics = false; // czy ma być wyświetlone formularz do dodawania tematów
  showFormViewTopics = false; // czy ma być wyświetlone formularz do wyświetlania tematów

  formValid = false;
  messageAddTopic = '';
  messageView = '';

  showTopicsList = false;
  topics: Topic[] = [];


  constructor(private teamService: TeamService, private studentService: StudentService, private topicService: TopicService, private router: Router) {
    this.teamService.getTeams().subscribe({
      next: data => {
        this.teams = data;
      },
      error: err => {
        console.error(err);
      }
    });

    this.topicService.getTopics().subscribe({
      next: data => {
        this.topics = data;
      },
      error: err => {
        console.error(err);
      }
    });
  }


  goToZarzadznieProjektem() {
    this.router.navigateByUrl('/supervisor/team-manage');

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
  validateFormTeam() {
    return this.formTeamValid = this.limit > 0 && this.limit < 7
  }

  submitTeamFormTeam(event: Event) {
    let team: Team = new Team(this.limit);
    event.preventDefault();
    if (this.validateFormTeam()) {
      this.teamService.createTeam(team).subscribe({
        next: data => {
          this.limit = 1;
          console.log(data);
          this.messageAddTeam = 'Zespół dodany poprawnie!';
          this.closeFormAddTeam();
        },
        error: err => {
          console.error(err);
          this.messageAddTeam = 'Błąd przy dodawaniu zespołu';
        }
      });
    }
  }

  submitStudent(studentId: bigint){
    this.teamService.addStudent({'studentId': studentId, 'teamId': this.teamId}).subscribe({
      next: data => {
        this.teamId = BigInt(0);
        console.log(data);
        this.closeFormAddStudent();
        this.showTeams();
      },
      error: err => {
        console.error(err);
      }
    });
  }


  openFormAddTopic() {
    this.showFormAddTopics = true;
  }

  closeFormAddTopic() {
    this.showFormAddTopics = false;
  }

  openFormViewTopic() {
    this.showTopics();
    this.showFormViewTopics = true;
  }

  closeFormViewTopic() {
    this.showFormViewTopics = false;
  }

  submitFormTopic(event: Event) {
    let topic: Topic = new Topic(this.topicName, this.topicDescription);
    event.preventDefault();
    if (this.validateFormTopic()) {
      this.topicService.createTopic(topic).subscribe({
        next: data => {
          this.topicName;
          this.topicDescription;
          console.log(data);
          this.messageAddTopic = 'Temat dodany poprawnie!';
          this.closeFormAddTopic();
        },
        error: err => {
          console.error(err);
          this.messageAddTopic = 'Błąd przy dodawaniu tematu';
        }
      });
    }
  }


  validateFormTopic() {
    this.formValid = this.topicName.trim() !== '' && this.topicDescription.trim() !== '';
    return this.formValid;
  }

  showTopics() {
    this.messageView = '';
    this.showTopicsList = true;
    this.topicService.getTopics().subscribe({
      next: data => {
        console.log(data);
        this.topics = data;
      },
      error: err => {
        console.error(err);
        this.messageView = 'Nie udało się pobrać tematów.';
      }
    });
  }

  @HostListener('document:keydown', ['$event']) onKeydownHandler(event: KeyboardEvent) {
    if (event.keyCode === 27) { // 27 - ESC_KEY code
      this.showFormAddTopics = false;
      this.showFormViewTopics = false;
      this.showFormViewTeams = false;
      this.showFormAddTeam = false;
    }
  }


  ngOnInit(): void {
  }
}
