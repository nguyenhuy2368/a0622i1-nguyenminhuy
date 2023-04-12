import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaytinhDongianComponent } from './maytinh-dongian.component';

describe('MaytinhDongianComponent', () => {
  let component: MaytinhDongianComponent;
  let fixture: ComponentFixture<MaytinhDongianComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaytinhDongianComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaytinhDongianComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
