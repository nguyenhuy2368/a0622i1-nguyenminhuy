import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../model/category';
import {HouseService} from '../../service/house.service';
import {Router} from '@angular/router';
import {House} from '../../model/house';
import {City} from '../../model/city';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  createForm: FormGroup;
  tempHouse: House;
  categoryList: Category[];
  cityList: City[];

  constructor(private fb: FormBuilder, private houseService: HouseService, private route: Router) {
  }

  ngOnInit(): void {
    this.houseService.getCategoryList().subscribe(value => {
      this.categoryList = value;
      console.log(this.categoryList);
      this.houseService.getCityList().subscribe(data => {
        this.cityList = data;
        this.initForm();
      }, error => {
        console.log('Get city list error: ' + error);
      });
    }, error => {
      console.log('Get category list error: ' + error);
    });
  }

  initForm() {
    this.createForm = this.fb.group({
      category: '',
      city: '',
      dateOfPost: '',
      post: '',
      status: '',
      address: ['', Validators.required],
      area: ['', [Validators.required, Validators.min(20)]],
      direction: '',
      title: ['', Validators.required],
      content: ['', Validators.required],
      price: ['', [Validators.required, Validators.min(100000000)]],
    });
  }

  submit() {
    const house = this.createForm.value;
    this.houseService.save(house).subscribe(() => {
      this.route.navigateByUrl('/houselist');
    });
  }

}
