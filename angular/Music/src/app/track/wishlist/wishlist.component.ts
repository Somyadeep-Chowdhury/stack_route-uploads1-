import { Component, OnInit } from '@angular/core';
import { TrackService } from '../track.service';
import { Track } from '../Track';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {
  private tracks: Array<Track>;
  private statusCode: number;

  constructor(private trackService: TrackService, private snackBar: MatSnackBar) {
    this.tracks = [];
  }
  ngOnInit() {
    this.fetchTracks();
  }

  private fetchTracks() {
    this.trackService.getAddedTracks().subscribe((res: any) => {
      this.tracks = res;
      console.log(this.tracks);
      });
  }

}
