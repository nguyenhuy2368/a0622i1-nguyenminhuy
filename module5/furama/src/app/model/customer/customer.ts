import {CustomerType} from './customer-type';
import {Gender} from '../gender';

export interface Customer {
  id: number;
  name: string;
  dateOfBirth?: Date;
  gender: Gender;
  idCard: number;
  phoneNumber: number;
  email: string;
  address: string;
  customerType: CustomerType;

}
