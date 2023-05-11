import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_AUTH_URL = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
      return this.http.post(API_AUTH_URL + 'signin', {username, password,}, httpOptions);
  }

  register(username: string, email: string, password: string): Observable<any> {
      return this.http.post(API_AUTH_URL + 'signup', {username, email, password,}, httpOptions);
  }

  logout() {
      return this.http.post(API_AUTH_URL + 'logout', { }, httpOptions);
  }

}
