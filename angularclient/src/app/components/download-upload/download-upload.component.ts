import {Component, OnInit} from '@angular/core';
import {StorageService} from "../../services/storage/storage.service";
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DownloadUploadService} from "../../services/file/download-upload.service";


@Component({
  selector: 'app-download-upload',
  templateUrl: './download-upload.component.html',
  styleUrls: ['./download-upload.component.scss']
})
export class DownloadUploaddComponent {
  files: File[] = [];

  constructor(private DownloadUploadService: DownloadUploadService, private storageService: StorageService) {
  }

  onFileSelected(event: any) {
    const selectedFile = event.target.files[0];
    this.files.push(selectedFile);
    console.log('Файл добавлен:', selectedFile);
  }

  addFile() {
    const fileInput = document.getElementById('fileInput');
    if (fileInput != null) {
      fileInput.click();

    }
  }


  uploadFiles() {

    const formData: FormData = new FormData();
    for (let i = 0; i < this.files.length; i++) {
      formData.append('file[]', this.files[i], this.files[i].name);
    }

    if (formData!=null)
    {
      this.DownloadUploadService.uploadFiles(formData)
    }
  }

}
