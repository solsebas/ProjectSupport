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


  private getHeaderWithToken(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.storageService.getUser().token);
  }

  getPublicContent(): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.get(API_URL + 'all', { responseType: 'text', headers });
  }
  getUserBoard(): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.get(API_URL + 'studentUser', { responseType: 'text', headers  });
  }

  getSupervisorBoard(): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.get(API_URL + 'supervisorUser', { responseType: 'text', headers  });
  }

  getAdminBoard(): Observable<any> {
    // var cos = this.storageService.getUser().token; /* "token..." */
    // var test2 = this.storageService.getUser(); // Object { token: "token... }

    const headers = this.getHeaderWithToken();
    return this.http.get(API_URL + 'admin', { responseType: 'text', headers });
  }
}
