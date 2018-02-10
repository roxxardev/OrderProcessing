import {Directive, EventEmitter, HostListener, Inject, Output} from '@angular/core';
import {DOCUMENT} from "@angular/common";

@Directive({
  selector: '[appScrollTracker]'
})
export class ScrollTrackerDirective {

  @Output() scrolledDown: EventEmitter<boolean> = new EventEmitter();

  constructor(@Inject(DOCUMENT) private document: Document) {
  }

  @HostListener("window:scroll", [])
  onWindowScroll() {
    if (Math.abs(document.body.scrollHeight - (window.scrollY + window.innerHeight)) <= 20) {
      this.scrolledDown.emit(true);
    }
  }

}
