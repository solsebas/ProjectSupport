import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DownloadUploacddComponent } from './download-upload.component';

describe('DownloadUploadComponent', () => {
  let component: DownloadUploadComponent;
  let fixture: ComponentFixture<DownloadUploadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DownloadUploadComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DownloadUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

