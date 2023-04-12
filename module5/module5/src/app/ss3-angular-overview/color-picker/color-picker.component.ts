import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {
  red = '#FF0000';
  blue = '#0000FF';
  yellow = '#FFFF00';
  color = 'red';
  constructor() { }

  ngOnInit(): void {
  }
  change(s: string) {
    this.color = s;
  }
}
