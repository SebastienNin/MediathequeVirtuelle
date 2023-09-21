import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonnalizedListComponent } from './personnalizedList.component';

describe('PersonnalizedListComponent', () => {
  let component: PersonnalizedListComponent;
  let fixture: ComponentFixture<PersonnalizedListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonnalizedListComponent]
    });
    fixture = TestBed.createComponent(PersonnalizedListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
