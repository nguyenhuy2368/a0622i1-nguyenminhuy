import {CustomerType} from './customer-type';
import {Data} from '@angular/router';
import {Gender} from '../gender';



export interface Customer {
  id: number;
  name: string;
  dateOfBirth?: Data;
  gender: Gender;
  idCard: number;
  phoneNumber: number;
  email: string;
  address: string;
  customerType: CustomerType;
}
