import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatchpokemonComponent } from './catchpokemon.component';

describe('CatchpokemonComponent', () => {
  let component: CatchpokemonComponent;
  let fixture: ComponentFixture<CatchpokemonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CatchpokemonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CatchpokemonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
