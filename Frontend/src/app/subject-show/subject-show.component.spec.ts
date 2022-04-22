import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectShowComponent } from './subject-show.component';

describe('SubjectShowComponent', () => {
  let component: SubjectShowComponent;
  let fixture: ComponentFixture<SubjectShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubjectShowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubjectShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
