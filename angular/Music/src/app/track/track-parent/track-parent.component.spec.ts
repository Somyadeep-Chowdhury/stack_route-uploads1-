import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackParentComponent } from './track-parent.component';

describe('TrackParentComponent', () => {
  let component: TrackParentComponent;
  let fixture: ComponentFixture<TrackParentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackParentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
