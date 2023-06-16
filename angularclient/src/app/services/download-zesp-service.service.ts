import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

import {StorageService} from "./storage/storage.service";//chek this line
import {Observable} from "rxjs";
const API_FILES_URL = 'http://localhost:8080/api/files/first';

@Injectable({
  providedIn: 'root'
})
export class DownloadZespServiceService {

  constructor() { }
}
