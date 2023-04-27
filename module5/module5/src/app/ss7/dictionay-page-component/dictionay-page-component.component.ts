import {Component, OnInit} from '@angular/core';
import {Iword} from '../iword';
import {DictionaryService} from '../../service/dictionary.service';

@Component({
  selector: 'app-dictionay-page-component',
  templateUrl: './dictionay-page-component.component.html',
  styleUrls: ['./dictionay-page-component.component.css']
})
export class DictionayPageComponentComponent implements OnInit {
  wordList: Iword[];

  constructor(private dictionaryService: DictionaryService) {
  }

  ngOnInit(): void {
    this.dictionaryService.findAll();
  }


}
