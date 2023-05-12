import {Component, OnInit} from '@angular/core';
import {LoHangService} from '../../service/loHang.service';
import {ILoHang} from '../../model/lohang';
import {MatDialog} from '@angular/material/dialog';
import {DeleteComponent} from '../delete/delete.component';
import {CreateComponent} from '../create/create.component';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  lohangs: ILoHang | any;
  p: number | any;
  name: any;
  ngayhethan: any;
  tungay: any;
  denngay: any;

  constructor(private loHangService: LoHangService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.loHangService.getAllEntity().subscribe(
      (data) => {
        this.lohangs = data;
      },
      () => {
      },
      () => {
      }
    );
  }

  timkiem() {
    this.loHangService.searchByName(this.name).subscribe(
      (data) => {
        this.lohangs = data;
      }
    );
  }

  timkiemnhh() {
    this.loHangService.searchByNHH(this.ngayhethan).subscribe(
      (data) => {
        this.lohangs = data;
      }
    );
  }

  openDialogNhapHang() {
    const dialogRefCreate = this.dialog.open(CreateComponent, {
      width: '800px'
    });
    dialogRefCreate.afterClosed().subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.ngOnInit();
      }
    );
  }

  openDialogDelete(lohang: ILoHang) {
    const dialogRefDelete = this.dialog.open(DeleteComponent, {
      width: '400px',
      data: lohang,
      disableClose: true
    });
    dialogRefDelete.afterClosed().subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.ngOnInit();
      }
    );
  }
}
