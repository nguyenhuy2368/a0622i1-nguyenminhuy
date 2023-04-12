import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ArticleComponent } from './article/article.component';
import { LikeComponent } from './like/like.component';
import {FormsModule} from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';



@NgModule({
  declarations: [ArticleComponent, LikeComponent, NavbarComponent, FooterComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class Ss4Module { }
