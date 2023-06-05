import {Component, HostListener} from '@angular/core';
import { TopicService } from "../../services/topic/topic.service";
import { AuthService } from "../../services/auth/auth.service";
import {Topic} from "../../models/topic";

@Component({
  selector: 'app-topic-form',
  templateUrl: './topic-form.component.html',
  styleUrls: ['./topic-form.component.scss']
})
export class TopicFormComponent {

  topicName = '';
  topicDescription = '';
  archieve=false;
  showFormAddTopics = false; // czy ma być wyświetlone formularz do dodawania tematów
  showFormViewTopics = false; // czy ma być wyświetlone formularz do wyświetlania tematów

  formValid = false;
  messageAdd = '';
  messageView = '';

  showTopicsList = false;
  topics: Topic[] = [];
  filteredTopics: Topic[] = [];


  constructor(private topicService: TopicService) {

    this.topicService.getTopics().subscribe({
      next: data => {
        this.topics = data;
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

  submitForm(event: Event) {
    let topic: Topic = new Topic(this.topicName, this.topicDescription, this.archieve);
    event.preventDefault();
    if (this.validateForm()) {
      this.topicService.createTopic(topic).subscribe({
        next: data => {
          this.topicName;
          this.topicDescription;
          this.archieve = false;
          console.log(data);
          this.messageAdd = 'Temat dodany poprawnie!';
          this.closeFormAddTopic();
        },
        error: err => {
          console.error(err);
          this.messageAdd = 'Błąd przy dodawaniu tematu';
        }
      });
    }
  }

  validateForm() {
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

  @HostListener('document:keydown', ['$event']) onKeydownHandler(event: KeyboardEvent) {
    if (event.keyCode === 27) { // 27 - ESC_KEY code
      this.showFormAddTopics = false;
      this.showFormViewTopics = false;
    }
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

}
