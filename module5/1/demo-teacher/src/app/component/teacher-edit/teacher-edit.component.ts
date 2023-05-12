import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {TeacherService} from '../../service/teacher.service';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {TeacherTypeService} from '../../service/teacherType.service';
import {Teacher} from '../../model/teacher';
import {TeacherType} from '../../model/teacher-type';

@Component({
  selector: 'app-teacher-edit',
  templateUrl: './teacher-edit.component.html',
  styleUrls: ['./teacher-edit.component.css']
})
export class TeacherEditComponent implements OnInit {

  rfTeacher: FormGroup;

  teacher: Teacher = {
    id: 1,
    name: 'Nguyễn Văn A',
    salary: 50000000,
    vote: 5
  };
  id: number;
  teacherTypeList: TeacherType[];

  constructor(private teacherService: TeacherService, private activatedRoute: ActivatedRoute,
              private router: Router, private teacherTypeService: TeacherTypeService) {
  }

  async ngOnInit(): Promise<void> {
    await this.teacherTypeService.findAll().subscribe(next => {
      this.teacherTypeList = next;
    });

    await this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
        const key = +paramMap.get('id');
        this.id = key;
        this.teacherService.findById(key).subscribe(data => {
          // this.rfTeacher.patchValue(data[0]);
          this.rfTeacher = new FormGroup({
            name: new FormControl(data[0].name, [Validators.required, Validators.minLength(5), Validators.pattern('^[^0-9]+$')]),
            salary: new FormControl(data[0].salary, [Validators.required, this.checkSalary]),
            // teacherType: new FormControl(data[0])
            teacherType: new FormControl(this.teacherTypeList.filter(item => item.id === data[0].teacherType.id)[0])
          });
        });
      }
    );
  }

  checkSalary(control: AbstractControl) {
    const salary = control.value;

    if (salary < 0) {
      return {ngheo: true};
    }
    if (salary > 1000000) {
      return {giau: true};
    }
    return null;
  }

  addTeacher(name: string, salary: string) {
    this.teacherService.update({...this.rfTeacher.value, vote: 0, id: this.id}).subscribe();
    this.router.navigateByUrl('/teacher');
  }
}
