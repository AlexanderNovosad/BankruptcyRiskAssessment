import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BancruptcyAnalysisComponent } from './bancruptcy-analysis.component';

describe('BancruptcyAnalysisComponent', () => {
  let component: BancruptcyAnalysisComponent;
  let fixture: ComponentFixture<BancruptcyAnalysisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BancruptcyAnalysisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BancruptcyAnalysisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
