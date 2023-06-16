import {Component, OnInit} from '@angular/core';
import {StorageService} from "../../services/storage/storage.service";
import {Observable, Subscription} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DownloadUploadService} from "../../services/file/download-upload.service";
import {TeamMember} from "../../models/team-member";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-download-upload',
  templateUrl: './download-upload.component.html',
  styleUrls: ['./download-upload.component.scss']
})
export class DownloadUploaddComponent {
  files: File | null = null;
  selectedId: number = 0;
  member: TeamMember | null = null;

  constructor(private route: ActivatedRoute, private DownloadUploadService: DownloadUploadService, private storageService: StorageService, private router: Router) {
    const sub: Subscription =
      this.route.params.subscribe(params => {
        this.selectedId = params['id'];
      })
  }


  onFileSelected(event: any) {
    const selectedFile = event.target.files[0];
    this.files = selectedFile;
    console.log('Файл добавлен:', selectedFile);
  }

  addFile() {
    const fileInput = document.getElementById('fileInput');
    if (fileInput != null) {
      fileInput.click();

    }
  }


  uploadFiles() {
    if (this.selectedId && this.files) {
      this.DownloadUploadService.uploadFiles(this.selectedId, this.files)
        .subscribe(
          (response: any) => {
            console.log('Файл успешно загружен', response);
            // Выполните необходимые действия после успешной загрузки файла
          },
          (error: any) => {
            console.error('Ошибка загрузки файла', error);
            // Обработайте ошибку загрузки файла
          }
        )

    }
  }
}
