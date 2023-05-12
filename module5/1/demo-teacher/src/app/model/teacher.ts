import {TeacherType} from './teacher-type';

export interface Teacher {
  id: number;
  name: string;
  salary?: number;
  vote: number;
  teacherType?: TeacherType;
}
