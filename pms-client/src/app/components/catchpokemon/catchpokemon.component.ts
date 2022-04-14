import { Component, OnInit } from '@angular/core';
import { PokemonService } from 'src/app/services/pokemon.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-catchpokemon',
  templateUrl: './catchpokemon.component.html',
  styleUrls: ['./catchpokemon.component.css']
})
export class CatchpokemonComponent implements OnInit {
  dataId: number = Math.floor(Math.random() * (152 - 1) ) + 1;
  userId?: number;
  data?: any;
  constructor(private pokemonService: PokemonService, private token: TokenStorageService) { }

  ngOnInit(): void {
    this.userId = this.token.getUser().id
    this.pokemonService.getPokemonData(this.dataId).subscribe(
      res => {
        console.log(res);
        this.data = res;
      }
    )
  }

  addPokemon(){
    console.log("USERID: " + this.userId)
    console.log(this.data);
    this.pokemonService.addUserPokemon(this.userId, this.data).subscribe(
      res => {
        console.log(res);
      }
    );
  }

}
