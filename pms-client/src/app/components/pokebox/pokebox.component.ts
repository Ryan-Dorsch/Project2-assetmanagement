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

  constructor(private pokemonService: PokemonService, private token: TokenStorageService) { }

  ngOnInit(): void {
    const user = this.token.getUser();
    this.userId = user.id;
    this.fetchUserPokemon(this.userId);
  }

  fetchUserPokemon(id: any): void {
    this.pokemonService.getUserPokemon(id)
      .subscribe(
        data => {
          this.pokemon = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
