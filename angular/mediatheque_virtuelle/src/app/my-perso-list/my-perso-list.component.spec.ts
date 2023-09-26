import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPersoListComponent } from './my-perso-list.component';

describe('MyPersoListComponent', () => {
  let component: MyPersoListComponent;
  let fixture: ComponentFixture<MyPersoListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyPersoListComponent]
    });
    fixture = TestBed.createComponent(MyPersoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
