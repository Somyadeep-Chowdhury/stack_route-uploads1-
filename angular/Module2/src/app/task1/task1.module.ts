import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Scenario1Component } from './scenario1/scenario1.component';

@NgModule({
  declarations: [Scenario1Component],
  imports: [
    CommonModule
  ],
  exports: [
    Scenario1Component,
  ]
})
export class Task1Module { }
