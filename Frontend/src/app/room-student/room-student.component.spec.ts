import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomStudentComponent } from './room-student.component';

describe('RoomStudentComponent', () => {
  let component: RoomStudentComponent;
  let fixture: ComponentFixture<RoomStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoomStudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
