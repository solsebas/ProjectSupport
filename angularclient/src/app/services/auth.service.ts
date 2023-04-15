import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    return this.http.post(
        AUTH_API + 'signin',
        {
          username,
          password,
        },
        httpOptions
    );
  }

  register(username: string, email: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'signup',
      {
        username,
        email,
        password,
      },
      httpOptions
    );
  }


    logout() {
        return this.http.post(AUTH_API + 'logout', { }, httpOptions).subscribe(
            response => {
                console.log('Logged out successfully');
                // Redirect to the login page or update the UI as needed
            },
            error => {
                console.error('Error logging out:', error);
                // Handle the error as needed
            }
        );
    }
}
