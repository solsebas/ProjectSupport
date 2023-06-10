import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {StorageService} from "../storage/storage.service";
import {Observable} from "rxjs";
import {Student} from "../../models/student";

const API_STUDENT_URL = 'http://localhost:8080/api/student/';
@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient, private storageService: StorageService) { }

  private getHeaderWithToken(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.storageService.getUser().token)
  }

  getStudents(): Observable<Student[]>{
    this.storageService.getUser().id;

    const headers = this.getHeaderWithToken();
    return this.http.get<Student[]>(API_STUDENT_URL + 'students', {headers})
  }

  getStudentsByTerm(termid: bigint): Observable<Student[]> {
    this.storageService.getUser().id;
    const headers = this.getHeaderWithToken();
    return this.http.get<Student[]>(API_STUDENT_URL + 'studentsT/' + termid, {headers});
  }
}
