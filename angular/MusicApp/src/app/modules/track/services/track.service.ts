import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Track } from '../classes/track';
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TrackService {

  private lastFmGetTopTracksUrl: string;
  private country: string;
  private apiKey: string;
  private format: string;
  private limit: string;
  private track: Track;
  private tracks: Array<Track>;
  private trackSubject: BehaviorSubject<Track[]>;
  private errorMsg: string;
 private errorStatus: string;
 private errorBody: string;
 private microServiceUrl = 'http://1172.23.239.69:8999/tracks/api/v1/';
 private lastFmSearchTrackUrl: string;

  constructor(private http: HttpClient) {
    this.lastFmGetTopTracksUrl = 'http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks';
    this.lastFmSearchTrackUrl = 'http://ws.audioscrobbler.com/2.0/?method=track.search';
    this.country = '&country=';
    this.apiKey = '&api_key=a24ec782151d99ebabddb81b2b5eccb2';
    this.format = '&format=json';
    this.limit = '&limit=';
   }

   getTopTracks(country: string, limit: number) {
     const url = this.lastFmGetTopTracksUrl + this.country + country + this.apiKey + this.format + this.limit + limit;
     console.log(url);
     this.tracks = [];
     this.trackSubject = new BehaviorSubject(this.tracks);
     this.http.get(url).subscribe(
       data => {
         console.log(data);
         const trackList = data['tracks']['track'];
         trackList.forEach(
           item => {
             this.track = new Track();
             const tName = '' + item.name;
            const sName = '' + item.artist.name;
             this.track.trackId = tName.replace(' ', '_') + '_' + sName.replace(' ' , '_');
             this.track.trackName = item.name;
             this.track.trackUrl = item.url;
             this.track.trackSinger = item.artist.name;
             this.track.trackImageUrl = item.image[3]['#text'];
             this.track.comment = '';
             this.tracks.push(this.track);
           });
           this.trackSubject.next(this.tracks);
       });
       return this.trackSubject;
   }


   addToPlayList(track: Track) {
    console.log(track);
    return this.http
    .post(this.microServiceUrl + 'tracks/track', track, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  getAddedTracks() {
    console.log('Added Tracks');
    return this.http.get(this.microServiceUrl + 'tracks', { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  updateAddedTrack(track: Track) {
    return this.http
    .put(this.microServiceUrl + 'tracks/track', track, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  deleteTrackFromPlayList(trackId: string) {
    console.log(this.microServiceUrl + 'tracks/track/' + trackId);
    return this.http.delete(this.microServiceUrl + 'tracks/track/' + trackId, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  searchAddedTracks(trackName: string) {
    return this.http.get(this.microServiceUrl + 'tracks/' + trackName, { observe: 'response' })
    .pipe(catchError(this.handleError));
  }

  serachTrackFM(trackName: string, limit: number) {
    const url = this.lastFmSearchTrackUrl + this.apiKey + this.format + this.limit + limit + '&track=' + trackName;
    this.tracks = [];
    this.trackSubject = new BehaviorSubject(this.tracks);
    this.http.get(url).subscribe(response => {
      // console.log(response);
      const trackList = response['results']['trackmatches']['track'];
      console.log(trackList);
      trackList.forEach( data => {
        this.track = new Track();
        const tName = '' + data.name;
        const sName = '' + data.artist.name;
        this.track.trackId = tName.replace(' ', '_') + '_' + sName.replace(' ' , '_');
        this.track.trackName = data.name;
        this.track.trackUrl = data.url;
        this.track.trackSinger = data.artist;
        this.track.trackImageUrl = data.image[3]['#text'];
        this.track.comment = '';

        this.tracks.push(this.track);
      });
      console.log(this.tracks);
      this.trackSubject.next(this.tracks);
    });
    return this.trackSubject;
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.log('An error occured :', error.error.message);
    } else {
      this.errorStatus = `${error.status}`;
      console.log('Error msg', this.errorStatus);
      this.errorBody = `${error.error}`;
      console.log(
        `Backened returned code ${error.status},` + `body was :${error.error}`
      );
    }

    return throwError(this.errorStatus);
  }
}
