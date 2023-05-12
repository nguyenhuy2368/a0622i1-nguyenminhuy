import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ISanPham} from '../../model/sanpham';
import {MatDialogRef} from '@angular/material/dialog';
import {LoHangService} from '../../service/loHang.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  sanphams: ISanPham | any;
  loHangForm = new FormGroup({
    idLoHang: new FormControl('', [Validators.required, Validators.pattern('LH-+[0-9]{4}')]),
    sanPham: new FormControl('', Validators.required),
    soLuong: new FormControl('', [Validators.required, Validators.min(1)]),
    ngayNhapHang: new FormControl('', Validators.required),
    ngaysanXuat: new FormControl('', Validators.required),
    ngayHetHan: new FormControl('', Validators.required),
  });

  constructor(private loHangService: LoHangService,
              public dialogRefCreate: MatDialogRef<CreateComponent>) {
  }

  ngOnInit(): void {
    this.loHangService.getAllSanPham().subscribe(
      (data) => {
        this.sanphams = data;
      },
      () => {
      },
      () => {
        console.log(this.sanphams);
      }
    );
  }
  luuLoHang() {
    if(this.loHangForm.valid){
      this.loHangService.saveLoHang(this.loHangForm.value).subscribe(
        ()=>{},
        ()=>{},
        ()=>{
          this.dialogRefCreate.close();
        }
      )
    }
  }

  closeDialogCreate() {
    this.dialogRefCreate.close();
  }

}
