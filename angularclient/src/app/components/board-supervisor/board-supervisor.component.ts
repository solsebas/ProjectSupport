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
import {Term} from "../../models/term";
import {TermService} from "../../services/term/term.service";

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


  formTeamValid: false | null | Topic = false;
  formStudentValid = false;
  messageAddTeam = '';
  terms: Term[] = [];
  supervisorTopics: Topic[] = [];
  selectedTerm: Term | null = null;
  selectedTopic: Topic | null = null;
  topicName = '';
  topicDescription = '';
  archieve=false;
  showFormAddTopics = false; // czy ma być wyświetlone formularz do dodawania tematów
  showFormViewTopics = false; // czy ma być wyświetlone formularz do wyświetlania tematów

  formValid = false;
  messageAddTopic = '';
  messageView = '';

  showTopicsList = false;
  topics: Topic[] = [];
  filteredTopics: Topic[] = [];
  termId: bigint = BigInt(0);

  constructor(private teamService: TeamService, private studentService: StudentService, private termService: TermService, private topicService: TopicService, private router: Router) {
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

    this.topicService.getTopicsSupervisor().subscribe({
      next: data => {
        this.supervisorTopics = data;
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

  validateForm() {
    return this.formTeamValid = this.limit > 0 && this.limit < 7 && this.selectedTerm && this.selectedTopic;
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
            this.messageAddTeam = 'Zespół dodany poprawnie!';

            if (team.topic) {
              team.topic.idUser = this.selectedTopic?.idUser;
            }
            this.closeFormAddTeam();
          },
          error: err => {
            console.error(err);
            this.messageAddTeam = 'Błąd przy dodawaniu zespołu';
          }
        });
      }
    }
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

  openForAddStudent(team: Team) {
    this.teamId = team?.id || this.teamId;
    this.termId = (team?.term?.id || this.termId) as bigint;

    this.showStudents();
    this.showStudentList = true;
  }

  closeFormAddStudent(){
    this.showStudentList = false;
  }

  showStudents() {
    this.studentService.getStudentsByTerm(this.termId).subscribe({
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
    let topic: Topic = new Topic(this.topicName, this.topicDescription, this.archieve);
    event.preventDefault();
    if (this.validateFormTopic()) {
      this.topicService.createTopic(topic).subscribe({
        next: data => {
          this.topicName;
          this.topicDescription;
          this.archieve;
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
        this.filteredTopics = this.topics.filter(topic => !topic.archieve);
      },
      error: err => {
        console.error(err);
        this.messageView = 'Nie udało się pobrać tematów.';
      }
    });
  }

  changeArchieve(topic: Topic) {
    topic.archieve = true;
    this.topicService.updateTopic(topic).subscribe({
      next: data => {
        console.log(data);
      },
      error: err => {
        console.error(err);
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
