import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Topic} from "../../models/topic";
import {StorageService} from "../storage/storage.service";
import {Team} from "../../models/team";

const API_TOPICS_URL = 'http://localhost:8080/api/topics/';


@Injectable({
  providedIn: 'root',
})
export class TopicService {
  constructor(private http: HttpClient, private storageService: StorageService) { }

  private getHeaderWithToken(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.storageService.getUser().token);
  }

  createTopic(topic: Topic): Observable<any> {
    const headers = this.getHeaderWithToken();
    topic.idUser = this.storageService.getUser().id;
    return this.http.post(API_TOPICS_URL,  topic, { headers } );
  }

  getTopics(): Observable<Topic[]> {
    // if user log
    this.storageService.getUser().id;

    const headers = this.getHeaderWithToken();
    return this.http.get<Topic[]>(API_TOPICS_URL, { headers } );
  }

  getTopicsSupervisor(): Observable<Topic[]> {
    let supervisorId = this.storageService.getUser().id;
    let queryParams = new HttpParams();
    queryParams = queryParams.append("supervisorId", supervisorId);

    const headers = this.getHeaderWithToken();
    return this.http.get<Topic[]>(API_TOPICS_URL + 'topicsSupervisor', { headers, params: queryParams });
  }

  updateTopic(topic: Topic): Observable<any> {
    const headers = this.getHeaderWithToken();
    return this.http.put(API_TOPICS_URL + topic.id, topic, { headers });
  }

}
