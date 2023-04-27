import {Component, OnInit} from '@angular/core';
import {Iword} from '../iword';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DictionaryService} from '../../service/dictionary.service';

@Component({
  selector: 'app-dictionary-detail-component',
  templateUrl: './dictionary-detail-component.component.html',
  styleUrls: ['./dictionary-detail-component.component.css']
})
export class DictionaryDetailComponentComponent implements OnInit {
  word: Iword;
  index: number;

  constructor(private activatedRoute: ActivatedRoute,
              private dictionaryService: DictionaryService) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const word = paramMap.get('word');
      this.word = this.dictionaryService.findByWord(word);
    });
  }

}
