import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MotelogComponent } from './motelog.component';

describe('MotelogComponent', () => {
  let component: MotelogComponent;
  let fixture: ComponentFixture<MotelogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MotelogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MotelogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
