import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-component2',
  templateUrl: './component2.component.html',
  styleUrls: ['./component2.component.scss']
})
export class Component2Component implements OnInit {

  @Output() sendToComp1 = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }
  myfunc(val) {
    this.sendToComp1.emit(val);
  }

}
