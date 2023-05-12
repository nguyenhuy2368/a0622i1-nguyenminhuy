import { TestBed } from '@angular/core/testing';

import { LoHangService } from './loHang.service';

describe('SanphamService', () => {
  let service: LoHangService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoHangService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
