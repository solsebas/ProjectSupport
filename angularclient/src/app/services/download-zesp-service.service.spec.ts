import { TestBed } from '@angular/core/testing';

import { DownloadZespServiceService } from './download-zesp-service.service';

describe('DownloadZespServiceService', () => {
  let service: DownloadZespServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DownloadZespServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
