import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {StorageService} from "../storage/storage.service";
import {Observable} from "rxjs";
import {Team} from "../../models/team";

const API_TEAMS_URL = 'http://localhost:8080/api/teams/';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient, private storageService: StorageService) { }

  private getHeaderWithToken(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.storageService.getUser().token)
  }

  createTeam(team: Team): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.post(API_TEAMS_URL, team, { headers });
  }

  addStudent(teamStudent: any): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.post(API_TEAMS_URL + 'student', teamStudent, {headers});
  }

  getTeams(): Observable<Team[]>{
    this.storageService.getUser().id;

    const headers = this.getHeaderWithToken();
    return this.http.get<Team[]>(API_TEAMS_URL, {headers})
  }

}
