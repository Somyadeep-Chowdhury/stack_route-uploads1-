import { Component, OnInit } from '@angular/core';
import { Track } from '../../classes/track';
import { TrackService } from '../../services/track.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  private tracks: Array<Track>;
  private statusCode: any;
  private searchTrack: string;

  constructor(private trackService: TrackService, private snackBar: MatSnackBar, private route: ActivatedRoute) {
    this.tracks = [];
   }

  ngOnInit() {
    this.route.params.subscribe((data: any) => {
      this.searchTrack = data.search;
      console.log(this.searchTrack);
      if (this.searchTrack !== undefined && this.searchTrack !== '' && this.searchTrack.replace(' ', '').length > 0) {
        console.log('Search Track');
        this.trackService.serachTrackFM(this.searchTrack, 10).subscribe((res: any) => {
          this.tracks = [];
          this.tracks = res;
        });
      } else {
        console.log('Top 10 Track');
        this.trackService.getTopTracks('india', 10).subscribe((res: any) => {
          this.tracks = [];
          this.tracks = res;
          });
      }
    });
  }

  addToPlayList(track) {
    this.trackService.addToPlayList(track).subscribe(
      response => {
        this.statusCode = response.status;
        if (this.statusCode === 200) {
          console.log('Success', this.statusCode);
          this.snackBar.open('Track Successfully added !!!', '', {
            duration: 1500
          });
        }
      },
      err => {
        const errorStatus = err;
        this.statusCode = parseInt(errorStatus, 10);
        if (this.statusCode === 409) {
          this.snackBar.open('Track already added', '', {
            duration: 1500
          });
          this.statusCode = 0;
        }
    });
  }

}