import {Component, OnInit} from '@angular/core';
import {HouseService} from '../../service/house.service';
import {House} from '../../model/house';
import {Category} from '../../model/category';
import {forkJoin} from 'rxjs';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  houseList: House[];
  area = '';
  price = '';
  direction = '';
  categoryList: Category[];
  id: number;
  tempTitle: string;

  constructor(private houseService: HouseService) {
  }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    const categoryObs = this.houseService.getCategoryList();
    const houseListObs = this.houseService.findAll();
    forkJoin([categoryObs, houseListObs]).subscribe(value => {
      this.houseList = value[1];
      this.categoryList = value[0];
    });
  }
  search() {
    this.houseService.search(this.area, this.price, this.direction).subscribe(value => {
      this.houseList = value;
      console.log(value);
    });
  }

  sendId(id: number) {

  }
}
