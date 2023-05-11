import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user/user.service";
import {StorageService} from "../../services/storage/storage.service";
import {AuthService} from "../../services/auth/auth.service";

@Component({
  selector: 'app-board-user',
  templateUrl: './board-student.component.html',
  styleUrls: ['./board-student.component.scss']
})
export class BoardStudentComponent implements OnInit {
  content?: string;

  constructor(private userService: UserService, private storageService: StorageService) { }

  ngOnInit(): void {
    this.userService.getUserBoard().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.content = res.message;
          } catch {
            this.content = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.content = `Error with status: ${err.status}`;
        }
      }
    });
  }
}
