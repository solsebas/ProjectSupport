import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
// @ts-ignore
import {StorageService} from "../storage/storage.service";//chek this line
import {Observable} from "rxjs";
const API_FILES_URL = 'http://localhost:8080/api/files/';
@Injectable({
  providedIn: 'root'
})
export class DownloadUploadService {


  constructor(private http: HttpClient, private storageService: StorageService) { }
  private getHeaderWithToken(): HttpHeaders {
    return new HttpHeaders().set('Authorization', 'Bearer ' + this.storageService.getUser().token);
  }
  uploadFiles(id: number, file: File): Observable<any> {
    const url = API_FILES_URL;
    const formData: FormData = new FormData();
    formData.append('id', id.toString());
    formData.append('file', file);

    const headers = this.getHeaderWithToken();

    return this.http.post<any>(url, formData, { headers });
  }
}

