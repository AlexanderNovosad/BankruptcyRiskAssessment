import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinancialEnterpriseAnalysisComponent } from './financial-enterprise-analysis.component';

describe('FinancialEnterpriseAnalysisComponent', () => {
  let component: FinancialEnterpriseAnalysisComponent;
  let fixture: ComponentFixture<FinancialEnterpriseAnalysisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinancialEnterpriseAnalysisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinancialEnterpriseAnalysisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
