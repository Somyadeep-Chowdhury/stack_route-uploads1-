import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Track } from '../Track';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-track',
  templateUrl: './track.component.html',
  styleUrls: ['./track.component.css']
})
export class TrackComponent implements OnInit {

  comments: string;
  @Input()
  trackName: Track;
  @Input()
  trackImage: String;
  @Output() trackAddEvent = new EventEmitter<Track>();
  // @Input()
  // statusCode: number;
  // @Input()
  // watchListApi: boolean;
  // @Output()
  // addToWishList  = new EventEmitter();
  // @Output()
  // deleteFromWishlist = new EventEmitter();
  // @Output()
  // updateComments = new EventEmitter();
  // status: boolean;

  constructor() { }

  ngOnInit() {
  }

  addTrack() {
    this.trackAddEvent.emit(this.trackName);
  }

}
