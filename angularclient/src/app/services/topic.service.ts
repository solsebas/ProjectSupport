import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Topic} from "../models/topic";
import {StorageService} from "./storage.service";

const API_URL = 'http://localhost:8080/api/';


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
    return this.http.post(API_URL + 'topics/add',  topic, { headers } );
  }

  getTopics(): Observable<Topic[]> {
    // if user log
    this.storageService.getUser().id;


    const headers = this.getHeaderWithToken();
    return this.http.get<Topic[]>(API_URL + 'topics/get', { headers } );
  }

  deleteTopic(topic: Topic): Observable<Topic[]> {
    const headers = this.getHeaderWithToken();
    return this.http.delete<any>(API_URL + 'topics/delete', { headers, body: topic });
  }
}
