import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WatchMyMediaComponent } from './watch-my-media.component';

describe('WatchMyMediaComponent', () => {
  let component: WatchMyMediaComponent;
  let fixture: ComponentFixture<WatchMyMediaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WatchMyMediaComponent]
    });
    fixture = TestBed.createComponent(WatchMyMediaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
