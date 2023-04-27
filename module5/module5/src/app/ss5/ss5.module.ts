import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';



@NgModule({
  declarations: [CountdownTimerComponent, RatingBarComponent],
  imports: [
    CommonModule
  ]
})
export class Ss5Module { }
