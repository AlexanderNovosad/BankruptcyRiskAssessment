import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManualInputFormComponent } from './manual-input-form.component';

describe('ManualInputFormComponent', () => {
  let component: ManualInputFormComponent;
  let fixture: ComponentFixture<ManualInputFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManualInputFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManualInputFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
