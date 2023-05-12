import {Category} from './category';
import {City} from './city';

export interface House {
  id?: number;
  category?: Category;
  city?: City;
  dateOfPost?: string;
  post?: string;
  status?: string;
  address?: string;
  area?: number;
  direction?: string;
  title?: string;
  content?: string;
  price?: number;
}
