import { Component } from '@angular/core';
import { TopicService } from "../../services/topic.service";

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

  constructor(private topicService: TopicService) { }

  openForm() {
    this.showForm = true;
  }

  closeForm() {
    this.showForm = false;
  }

  submitForm(event: Event) {
    event.preventDefault();
    if (this.validateForm()) {
      this.topicService.createTopic(this.topicName, this.topicDescription).subscribe({
        next: data => {
          console.log(data);
          this.message = 'Topic added successfully!';
          this.closeForm();
        },
        error: err => {
          console.error(err);
          this.message = 'Failed to add topic';
        }
      });
    }
  }

  validateForm() {
    this.formValid = this.topicName.trim() !== '' && this.topicDescription.trim() !== '';
    return this.formValid;
  }
}
