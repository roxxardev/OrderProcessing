import {animate, state, style, transition, trigger} from "@angular/animations";

export function slideToBottom() {
  return trigger('slideToBottom', [
    state('void', style({})),
    state('*', style({})),
    transition(':enter', [
      style({transform: 'translateY(-100%)'}),
      animate('1s ease-in-out', style({transform: 'translateY(0%)'}))
    ]),
    transition(':leave', [
      style({transform: 'translateY(0%)'}),
      animate('1s ease-in-out', style({transform: 'translateY(100%)'}))
    ])
  ]);
}
