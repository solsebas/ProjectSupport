import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentsTeamBoardComponent } from './students-team-board.component';

describe('StudentsTeamBoardComponent', () => {
  let component: StudentsTeamBoardComponent;
  let fixture: ComponentFixture<StudentsTeamBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentsTeamBoardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentsTeamBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
