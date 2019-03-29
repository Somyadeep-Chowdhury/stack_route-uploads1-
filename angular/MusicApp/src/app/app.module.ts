import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrackModule } from './modules/track/track.module';
import { HttpClientModule } from '@angular/common/http';
import { TrackService } from './modules/track/services/track.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TrackModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [TrackService],
  bootstrap: [AppComponent]
})
export class AppModule { }
