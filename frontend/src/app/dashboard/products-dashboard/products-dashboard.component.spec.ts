import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsDashboardComponent } from './products-dashboard.component';

describe('ProductsDashboardComponent', () => {
  let component: ProductsDashboardComponent;
  let fixture: ComponentFixture<ProductsDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductsDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
