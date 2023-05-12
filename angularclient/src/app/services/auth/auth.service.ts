import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {StorageService} from "../storage/storage.service";

const API_AUTH_URL = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
    constructor(private http: HttpClient, private storageService: StorageService) { }

    private getHeaderWithToken(): HttpHeaders {
      return new HttpHeaders().set('Authorization', 'Bearer ' + this.storageService.getUser().token)
    }

    login(username: string, password: string): Observable<any> {
        return this.http.post(API_AUTH_URL + 'signin', {username, password }, httpOptions);
    }

    register(username: string, email: string, password: string, firstname: string, surname: string): Observable<any> {
        const headers = this.getHeaderWithToken();
        headers.append('Content-Type', 'application/json');
        return this.http.post(API_AUTH_URL + 'signup', {username, email, password, firstname, surname }, { headers });
    }

    logout() {
        return this.http.post(API_AUTH_URL + 'logout', { }, httpOptions);
    }

}
