import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupervisorTeamBoardComponent } from './supervisor-team-board.component';

describe('SupervisorTeamBoardComponent', () => {
  let component: SupervisorTeamBoardComponent;
  let fixture: ComponentFixture<SupervisorTeamBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SupervisorTeamBoardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SupervisorTeamBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
