import {Injectable} from '@angular/core';
import {Iword} from '../ss7/iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  words: Iword[] = [
    {
      word: 'hello',
      mean: 'xin chao'
    },
    {
      word: 'hi',
      mean: 'xin chao'
    },
    {
      word: 'bye',
      mean: 'tam biet'
    }
  ];

  constructor() {
  }
  findAll(): Iword[] {
    return this.words;
  }
  findByWord(word: string){
    return this.words.find(item => item.word === word);
  }
}
