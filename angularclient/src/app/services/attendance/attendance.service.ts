import { Injectable } from '@angular/core';
import {Team} from "../../models/team";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {StorageService} from "../storage/storage.service";
import {Attendance} from "../../models/attendance";

const API_TEAMS_URL = 'http://localhost:8080/api/attendances/';
@Injectable({
  providedIn: 'root'
})
export class AttendanceService {

  private getHeaderWithToken(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.storageService.getUser().token)
  }
  constructor(private http: HttpClient, private storageService: StorageService) { }
  createAttendance(attendance: Attendance): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.post(API_TEAMS_URL, attendance, { headers });
  }
}
