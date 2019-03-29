import { Component, } from '@angular/core';

@Component({
  selector: 'app-parent-component',
  templateUrl: './parent-component.component.html',
  styleUrls: ['./parent-component.component.scss']
})
export class ParentComponentComponent {

  exampleParent: string;

  exampleMethodParent($event) {
    this.exampleParent = $event;
  }



}
