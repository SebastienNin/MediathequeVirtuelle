import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeMediaDetailsComponent } from './see-media-details.component';

describe('SeeMediaDetailsComponent', () => {
  let component: SeeMediaDetailsComponent;
  let fixture: ComponentFixture<SeeMediaDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SeeMediaDetailsComponent]
    });
    fixture = TestBed.createComponent(SeeMediaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
