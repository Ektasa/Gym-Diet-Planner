import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatlelogComponent } from './patlelog.component';

describe('PatlelogComponent', () => {
  let component: PatlelogComponent;
  let fixture: ComponentFixture<PatlelogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatlelogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PatlelogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
