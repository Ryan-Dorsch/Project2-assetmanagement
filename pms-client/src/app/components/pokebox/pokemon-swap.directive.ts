import {
  Directive,
  EventEmitter,
  HostBinding,
  HostListener,
  Input,
  Output,
} from '@angular/core';

@Directive({
  selector: '[appPokemonSwap]',
})
export class PokemonSwapDirective {
  constructor() {}

  @HostBinding('attr.draggable') draggable = true;
  @Input('elemPosition')
  elemPosition!: number;
  @Input('list') list: any;
  @Output('returnUpdatedList') returnUpdatedList = new EventEmitter<any>();

  @HostListener('dragstart', ['$event'])
  onDragStart(e: { dataTransfer: { setData: (arg0: string, arg1: number) => void; }; }) {
    e.dataTransfer.setData('data', this.elemPosition);
  }

  @HostListener('drop', ['$event'])
  onDrop(e: { preventDefault: () => void; dataTransfer: { getData: (arg0: string) => any; }; }) {
    e.preventDefault();
    let sourceElementIndex = e.dataTransfer.getData('data');
    let destElementIndex = this.elemPosition;
    let clonedList = [...this.list];
    if (sourceElementIndex !== destElementIndex) {
      clonedList.splice(destElementIndex, 1, this.list[sourceElementIndex]);
      clonedList.splice(sourceElementIndex, 1, this.list[destElementIndex]);
      this.returnUpdatedList.emit(clonedList);
    }
  }

  @HostListener('dragover', ['$event'])
  onDragOver(e: { preventDefault: () => void; }) {
    e.preventDefault();
  }
}