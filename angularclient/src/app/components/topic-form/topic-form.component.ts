import { Component } from '@angular/core';
import { TopicService } from "../../services/topic.service";
import { AuthService } from "../../services/auth.service";
import {Topic} from "../../models/topic";

@Component({
  selector: 'app-topic-form',
  templateUrl: './topic-form.component.html',
  styleUrls: ['./topic-form.component.scss']
})
export class TopicFormComponent {
  topicName = '';
  topicDescription = '';
  showForm = false;
  formValid = false;
  message = '';
  currentUser: any; //potrzebne do pokazania, który użytkownik aktualnie jest
  showTopicsList = false;
  topics: any[] = [];

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

  openForm() {
    this.showForm = true;
  }

  closeForm() {
    this.showForm = false;
  }

  submitForm(event: Event) {
    let topic: Topic = new Topic(this.topicName, this.topicDescription);


    event.preventDefault();
    if (this.validateForm()) {
      this.topicService.createTopic(topic).subscribe({
        next: data => {
          this.topicName = "";
          this.topicDescription = "";
          console.log(data);
          this.message = 'Temat dodany poprawnie!';
          this.closeForm();
        },
        error: err => {
          console.error(err);
          this.message = 'Błąd przy dodawaniu tematu';
        }
      });
    }
  }

  validateForm() {
    this.formValid = this.topicName.trim() !== '' && this.topicDescription.trim() !== '';
    return this.formValid;
  }

  showTopics() {
    this.showTopicsList = true;
    this.topicService.getTopics().subscribe({
      next: data => {
        console.log(data);
        this.topics = data;
      },
      error: err => {
        console.error(err);
        this.message = 'Failed to get topics';
      }
    });
  }
}
