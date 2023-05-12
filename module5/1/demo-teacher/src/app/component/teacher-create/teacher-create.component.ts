import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {TeacherService} from '../../service/teacher.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-teacher-create',
  templateUrl: './teacher-create.component.html',
  styleUrls: ['./teacher-create.component.css']
})
export class TeacherCreateComponent implements OnInit {
  rfTeacher: FormGroup;

  constructor(private teacherService: TeacherService,
              private router: Router) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.rfTeacher = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(5), Validators.pattern('^[^0-9]+$')]),
      salary: new FormControl('', [Validators.required, this.checkSalary])
    });
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
  addTeacher(name: string, salary: string){
    this.teacherService.save({... this.rfTeacher.value, vote: 0}).subscribe();
    this.router.navigateByUrl('/teacher');
  }
}
