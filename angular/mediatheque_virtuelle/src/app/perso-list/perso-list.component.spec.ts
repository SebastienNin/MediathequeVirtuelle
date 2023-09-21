import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersoListComponent } from './perso-list.component';

describe('PersoListComponent', () => {
  let component: PersoListComponent;
  let fixture: ComponentFixture<PersoListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersoListComponent]
    });
    fixture = TestBed.createComponent(PersoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
