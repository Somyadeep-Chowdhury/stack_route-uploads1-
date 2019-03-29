import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrackComponent } from './track/track/track.component';
import { WishlistComponent } from './track/wishlist/wishlist.component';

const routes: Routes = [
  { path: '', component: TrackComponent },
  { path: 'playlist', component: WishlistComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
