import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BancruptcyStatisticsComponent } from './bancruptcy-statistics.component';

describe('BancruptcyStatisticsComponent', () => {
  let component: BancruptcyStatisticsComponent;
  let fixture: ComponentFixture<BancruptcyStatisticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BancruptcyStatisticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BancruptcyStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
