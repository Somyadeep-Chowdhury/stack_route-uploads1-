import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { SearchComponent } from './search/search.component';
import { SearchParentComponent } from './search-parent/search-parent.component';
import { TrackParentComponent } from './track-parent/track-parent.component';
import { TrackComponent } from './track/track.component';
import { HttpClientModule } from '@angular/common/http';
import {MatCardModule, MatSnackBarModule} from '@angular/material';
import { TrackService } from './track.service';


@NgModule({
  declarations: [HeaderComponent,
     FooterComponent, WishlistComponent, SearchComponent, SearchParentComponent, TrackParentComponent, TrackComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    MatCardModule,
    MatSnackBarModule
  ],
  exports: [
    FooterComponent,
    HeaderComponent,
    SearchComponent,
    SearchParentComponent,
    TrackParentComponent,
    WishlistComponent,
    TrackComponent
  ],
  providers: [TrackService]
})
export class TrackModule { }
