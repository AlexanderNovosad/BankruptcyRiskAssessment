import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {NedosekinModelComponent} from "./nedosekin-model.component";


describe('NedosekinModelComponent', () => {
  let component: NedosekinModelComponent;
  let fixture: ComponentFixture<NedosekinModelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NedosekinModelComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NedosekinModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
