import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Track } from './Track';
import { Image } from './Image';
import { Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class TrackService {
//  public tracks;
  public lastFmUrl: string;
// public apiKey = 'a24ec782151d99ebabddb81b2b5eccb2';
  tracks: Array<Track>;
  thridPartyApi: string;
  country: string;
  apiKey: string;
  format: string;
  limit: string;
  trackObj: Track;
  imageObj: Image;
  trackSubject: Observable<any>;
  searchString: string;
  id: number;
  errorMsg: string;
  errorStatus: string;
  errorBody: string;
  mongoUrl: string;


  constructor(private http: HttpClient) {
    // tslint:disable-next-line:max-line-length
    this.lastFmUrl = 'http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks';
    this.country = '&country=';
    this.apiKey = '&api_key=0e197c0085c6c947d16ee02969146315';
    this.format = '&format=json';
    this.limit = '&limit=';
    this.mongoUrl = 'http://localhost:8080/api/v1';
    this.thridPartyApi =
    'http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&country=india&api_key=a24ec782151d99ebabddb81b2b5eccb2&format=json&limit=10';

   }

  getTrackDetails(): Observable<Array<Track>> {
    // // console.log('country in service', country);
    // console.log('url', this.thridPartyApi);
    // this.tracks = [];
    // this.http.get(this.thridPartyApi).subscribe(track => {
    //   const data = track['tracks']['track'];
    //   this.id = 0;
    //   data.forEach(targetData => {
    //     this.id++;
    //     this.trackObj = new Track();
    //     // this.imageObj = new Image();
    //     // this.imageObj.text = targetData['image'][2]['#text'];
    //     // this.imageObj.size = targetData['image'][2]['size'];
    //     this.trackObj = targetData;
    //     // this.trackObj.trackId = country.slice(0, 3) + this.id;
    //     this.tracks.push(this.trackObj);
    //   });
    //    this.trackSubject.next(this.tracks);
    // });
    // console.log("dsdoisyodsv"+this.trackSubject);
    // return this.trackSubject;
    console.log('url', this.thridPartyApi);
    return this.http.get<Track[]>(`${this.thridPartyApi}`);
  }

  addTracktoWishList(track: Track) {
    return this.http
      .post(this.mongoUrl + '/track', track, { observe: 'response' });
      // .pipe(catchError(this.handleError));
  }

  getAddedTracks() {
    return this.http.get(this.mongoUrl + 'track');
  }


  // private handleError(error: HttpErrorResponse) {
  //   if (error.error instanceof ErrorEvent) {
  //     console.log('An error occured :', error.error.message);
  //   } else {
  //     this.errorStatus = `${error.status}`;
  //     console.log('Error msg', this.errorStatus);
  //     this.errorBody = `${error.error}`;
  //     console.log(
  //       `Backened returned code ${error.status},` + `body was :${error.error}`
  //     );
  //   }

  //   return throwError(this.errorStatus);
  // }

}
