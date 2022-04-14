import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/model/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
@Component({
  selector: 'app-pokebox',
  templateUrl: './pokebox.component.html',
  styleUrls: ['./pokebox.component.css']
})
export class PokeboxComponent implements OnInit {

  pokemon?: Pokemon[];
  userId?: number;
  activeIndex = -1;
  moveIndex = -1;

  locations: Array<any> = new Array(30);

  constructor(private pokemonService: PokemonService, private token: TokenStorageService) { }

  ngOnInit(): void {
    this.userId = this.token.getUser().id
    this.locations.fill(0);
    this.fetchUserPokemon(this.userId);
  }

  fetchUserPokemon(id: any): void {
    this.pokemonService.getUserPokemon(id)
      .subscribe(
        data => {
          console.log(data);
          this.setPokemonLocation(data);
          this.pokemon=data;
      },
        error => {
          console.log(error);
      });
  }

  setPokemonLocation(userPokemon: Pokemon[]): void {
    //userPokemon.forEach(p)
    userPokemon.forEach(p => {
      if (!(p.location === undefined)){
        this.locations[p.location] = p;
      }
    });
    console.log(this.locations)
  }

  updateLocations(data: Array<any>): void {
    data.forEach((value, index) => {
      if(value!==0 && value.location !==index){
        value.location = index;
        console.log(value.id);
        console.log(value)
        this.pokemonService.updatePokemonLocation(value).subscribe(
          data => {
            console.log(data)
          }
        )
      }
    });
    this.locations = data;
  }


  setActiveIndex(i: any): void{
    if (this.locations[i] !== 0) {
      if (this.activeIndex === i){
        this.activeIndex = -1;
      } else {
        this.activeIndex=i;
      }
    }
  }



  // moveLocation(location: number): void {

  //   if(this.pokeActive && this.locations[location]===0){
  //     this.locations[location] = this.pokeActive;
  //     this.pokeActive.location = location;
  //   }
  // }

  // setActiveLocation(location: number): void{
  //   if (location===this.currentIndex){
  //     this.currentIndex=-1;
  //   } else {
  //     this.currentIndex = location;
  //     this.pokeActive = this.locations[location];
  //   }
    
  // }

  // isActive(location: number): boolean {
  //   return this.locations[location]===this.pokeActive;
  // }

}
