import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OverallRatingOfEnterprisesComponent } from './overall-rating-of-enterprises.component';

describe('OverallRatingOfEnterprisesComponent', () => {
  let component: OverallRatingOfEnterprisesComponent;
  let fixture: ComponentFixture<OverallRatingOfEnterprisesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OverallRatingOfEnterprisesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OverallRatingOfEnterprisesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
