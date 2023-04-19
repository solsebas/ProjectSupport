import {Component, Injectable, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-board-supervisor',
  templateUrl: './board-supervisor.component.html',
  styleUrls: ['./board-supervisor.component.scss']
})
export class BoardSupervisorComponent implements OnInit {
  form: any = {
    topic: null,
    name_character: null
  };

  content?: string;

  constructor(private userService: UserService, private http: HttpClient) { }

  onSubmit(): void {
    //alert(this.form.topic + " " + this.form.name_character)
    console.log(this.http)
    this.http.get("https://localhost:8080/index")
  }

  ngOnInit(): void {
    this.userService.getSupervisorBoard().subscribe({
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
