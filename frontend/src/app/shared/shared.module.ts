import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { ScrollTrackerDirective } from './scroll-tracker.directive';

@NgModule({
  exports: [
    CommonModule,
    ScrollTrackerDirective
  ],
  declarations: [ScrollTrackerDirective]
})
export class SharedModule {
}
