import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LiquidityStatisticsComponent } from './liquidity-statistics.component';

describe('LiquidityStatisticsComponent', () => {
  let component: LiquidityStatisticsComponent;
  let fixture: ComponentFixture<LiquidityStatisticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LiquidityStatisticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LiquidityStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
