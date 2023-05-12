import {Component, OnInit} from '@angular/core';
import {TeacherService} from '../../service/teacher.service';
import {Teacher} from '../../model/teacher';
import {TeacherType} from '../../model/teacher-type';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {
  teacherList: Teacher[];
  teacherTypeList: TeacherType[];

  constructor(private teacherService: TeacherService) {
  }

  ngOnInit(): void {
    this.teacherService.findAll().subscribe(next => {
      this.teacherList = next;
    });

    this.teacherService.findAll().subscribe(next => {
      this.teacherTypeList = next;
    });
  }

  search(name: string, idType: string) {
    this.teacherService.search(name, idType).subscribe(next=>{
      this.teacherTypeList = next;
    });
  }
}
