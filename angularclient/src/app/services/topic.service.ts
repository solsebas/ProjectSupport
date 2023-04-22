import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class TopicService {
  private topicsUrl = 'topics'; // url do endpointu API

  constructor(private http: HttpClient) { }

  createTopic(topicName: string, topicDescription: string): Observable<any> {
    return this.http.post(
      AUTH_API + this.topicsUrl,
      { name: topicName, description: topicDescription },
      httpOptions
    );
  }

}
