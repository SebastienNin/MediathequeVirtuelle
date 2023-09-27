import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersoListJoinMediaComponent } from './perso-list-join-media.component';

describe('PersoListJoinMediaComponent', () => {
  let component: PersoListJoinMediaComponent;
  let fixture: ComponentFixture<PersoListJoinMediaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersoListJoinMediaComponent]
    });
    fixture = TestBed.createComponent(PersoListJoinMediaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
