import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyRegistration } from './company-registration.component';

describe('CompanyRegistration', () => {
  let component: CompanyRegistration;
  let fixture: ComponentFixture<CompanyRegistration>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompanyRegistration ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyRegistration);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
