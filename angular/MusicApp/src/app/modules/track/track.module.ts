import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardComponent } from './components/card/card.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { PlaylistComponent } from './components/playlist/playlist.component';
import { MyMaterialModule } from 'src/app/mymaterial';

@NgModule({
  declarations: [CardComponent, HeaderComponent, HomeComponent, PlaylistComponent],
  imports: [
    CommonModule,
    MyMaterialModule
  ],
  exports: [HeaderComponent]
})
export class TrackModule { }
