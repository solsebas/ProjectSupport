import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {StorageService} from "../storage/storage.service";

const API_URL = 'http://localhost:8080/api/';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient, private storageService: StorageService) {}


  private getHeaderWithToken(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.storageService.getUser().token);
  }

  getPublicContent(): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.get(API_URL + 'public', { responseType: 'text' });
  }
  getAdminBoard(): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.get(API_URL + 'admin', { responseType: 'text', headers });
  }
}
