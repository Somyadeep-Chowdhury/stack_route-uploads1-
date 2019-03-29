import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child-component',
  templateUrl: './child-component.component.html',
  styleUrls: ['./child-component.component.scss']
})
export class ChildComponentComponent {

  @Output() exampleOutput = new EventEmitter<string>();


  display(value: string) {
    this.exampleOutput.emit(value);

  }

}
