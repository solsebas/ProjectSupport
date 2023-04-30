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
    return this.http.post(API_URL + 'topics',  JSON.parse(JSON.stringify(topic)), { headers } );
  }

  getTopics(): Observable<any> {
    // if user log
    this.storageService.getUser().id;
    

    const headers = this.getHeaderWithToken();
    return this.http.get<any>(API_URL + 'topics', { headers } );
  }

}
