import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {StorageService} from "./storage.service";

const API_URL = 'http://localhost:8080/api/test/';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient, private storageService: StorageService) {}

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }
  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'studentUser', { responseType: 'text' });
  }

  getSupervisorBoard(): Observable<any> {
    return this.http.get(API_URL + 'supervisorUser', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', this.storageService.getUser().token);
    // PROBLEM Z NAGŁÓWKIEM Bearer $token - i krzyczy na back w AuthEntryPointJwt że nie
    // !!!!!!!!!!!
    // !!!!!!!!!!!
    // !!!!!!!!!!!
    // !!!!!!!!!!!
    // TO DO

    return this.http.get(API_URL + 'admin', { responseType: 'text', headers });
  }
}
