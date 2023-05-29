import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {StorageService} from "../storage/storage.service";
import {Observable} from "rxjs";
import {Team} from "../../models/team";
import {TeamMember} from "../../models/team-member";

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

  getStudentsTeams(): Observable<Team[]>{
    let id = this.storageService.getUser().id;
    let queryParams = new HttpParams();
    queryParams = queryParams.append("id",id);

    const headers = this.getHeaderWithToken();
    return this.http.get<Team[]>(API_TEAMS_URL + 'student', {headers, params:queryParams})
  }

  getTeamMember(teamId: number): Observable<TeamMember>{
    let userId = this.storageService.getUser().id;
    let queryParams = new HttpParams();
    queryParams = queryParams.append("teamId",teamId);
    queryParams = queryParams.append("userId",userId);

    const headers = this.getHeaderWithToken();
    return this.http.get<TeamMember>(API_TEAMS_URL + 'member', {headers, params:queryParams})
  }

  getSupervisorTeams(): Observable<Team[]>{
    let id = this.storageService.getUser().id;
    let queryParams = new HttpParams();
    queryParams = queryParams.append("id",id);

    const headers = this.getHeaderWithToken();
    return this.http.get<Team[]>(API_TEAMS_URL + 'supervisor', {headers, params:queryParams})
  }

  getTeamMembers(teamId: number): Observable<TeamMember[]>{
    this.storageService.getUser().id;
    let queryParams = new HttpParams();
    queryParams = queryParams.append("teamId",teamId);

    const headers = this.getHeaderWithToken();
    return this.http.get<TeamMember[]>(API_TEAMS_URL + 'members', {headers, params:queryParams})
  }

  addGrade(member: TeamMember): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.put<TeamMember>(API_TEAMS_URL + 'member/' + member.id, member, { headers });
  }

  setStatus(team: Team): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.put<Team>(API_TEAMS_URL + 'status/' + team.id, team, { headers });
  }
}
