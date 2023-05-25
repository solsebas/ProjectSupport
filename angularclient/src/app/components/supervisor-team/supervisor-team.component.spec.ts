import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupervisorTeamComponent } from './supervisor-team.component';

describe('SupervisorTeamComponent', () => {
  let component: SupervisorTeamComponent;
  let fixture: ComponentFixture<SupervisorTeamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SupervisorTeamComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SupervisorTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
