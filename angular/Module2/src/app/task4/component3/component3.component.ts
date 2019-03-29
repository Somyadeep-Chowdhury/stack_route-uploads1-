import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-component3',
  templateUrl: './component3.component.html',
  styleUrls: ['./component3.component.scss']
})
export class Component3Component {

  @Output() sendToComp2 = new EventEmitter<string>();

  displayText(value: string) {
    this.sendToComp2.emit(value);
  }
}
