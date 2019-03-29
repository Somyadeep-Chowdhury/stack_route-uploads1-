import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'timer';
  name = 'Angular 6';
  timeLeft: number = 350;
  interval: any;
  math = Math;

  timebar: number;

  startTimer() {
    this.interval = setInterval(() => {
      if(this.timeLeft > 0) {
        this.timeLeft--;
        this.timebar = this.timeLeft/(3.5);
      }
    },1000)
  }

  // pauseTimer() {
  //   clearInterval(this.interval);
  // }

  // closeWindow(){
  //   this.interval = 
  // }

  // setTimeout(startTimer() => { alert("Hi"); } );


}
