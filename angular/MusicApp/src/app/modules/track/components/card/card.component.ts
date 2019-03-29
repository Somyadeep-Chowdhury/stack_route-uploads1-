import { Component, OnInit, Input, Output, EventEmitter, ViewChild, TemplateRef, ElementRef } from '@angular/core';
import { Track } from '../../classes/track';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  @Input() appTrack: Track;
  @Output() trackAddEvent = new EventEmitter<Track>();
  @Output() trackUpdateEvent = new EventEmitter<Track>();
  @Output() trackDeleteEvent = new EventEmitter<String>();

 private isHome: boolean;
 @ViewChild('callAPIDialog') callAPIDialog: TemplateRef<any>;
 @ViewChild('TrackComment') trackComment: ElementRef;
  constructor(private dialog: MatDialog) {
    this.isHome = true;
   }

  ngOnInit() {
    this.isHome = (location.pathname === '/' || location.pathname.search('/home') === 0);
  }

  addTrack() {
    // console.log('1');
    this.trackAddEvent.emit(this.appTrack);
  }

  updateTrack() {
    const dialogRef = this.dialog.open(this.callAPIDialog);
    dialogRef.afterClosed().subscribe(result => {
      if (result === 'yes') {
        this.appTrack.comment = this.trackComment.nativeElement.value;
        this.trackUpdateEvent.emit(this.appTrack);
      }
    });
  }

  deleteTrack() {
    this.trackDeleteEvent.emit(this.appTrack.trackId);
  }

  openTrackUrl() {
    window.open(this.appTrack.trackUrl);
  }

}
