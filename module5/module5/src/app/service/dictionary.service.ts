import {Injectable} from '@angular/core';
import {IWord} from '../model/iword';


@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  words: IWord[] = [
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
  findAll() {
    return this.words;
  }

  findByWord(word: string){
    return this.words.find(item => item.word === word);
  }
  translate(index) {
    return this.words[index];
  }
}
