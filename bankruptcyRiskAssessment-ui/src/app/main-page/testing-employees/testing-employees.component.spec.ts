import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestingEmployeesComponent } from './testing-employees.component';

describe('TestingEmployeesComponent', () => {
  let component: TestingEmployeesComponent;
  let fixture: ComponentFixture<TestingEmployeesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestingEmployeesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestingEmployeesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
