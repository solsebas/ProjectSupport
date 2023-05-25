import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Term} from "../../models/term";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {StorageService} from "../storage/storage.service";

const API_TERMS_URL = 'http://localhost:8080/api/terms/';
@Injectable({
  providedIn: 'root'
})
export class TermService {

  constructor(private http: HttpClient, private storageService: StorageService) { }

  private getHeaderWithToken(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.storageService.getUser().token)
  }

  getTerms(major: string, teamNumber: number): Observable<Term[]> {
    const headers = this.getHeaderWithToken();
    const params = new HttpParams()

    return this.http.get<Term[]>(API_TERMS_URL, { headers, params });
  }
}
