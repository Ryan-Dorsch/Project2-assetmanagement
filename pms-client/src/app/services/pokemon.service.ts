import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../model/pokemon';

const baseUrl = 'http://localhost:8080/api/users';
const apiUrl = 'https://pokeapi.co/api/v2/pokemon';
@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) { }

  getUserPokemon(id: any): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(`${baseUrl}/${id}`);
  }

  getPokemonData(id: any): Observable<any> {
    return this.http.get(`${apiUrl}/${id}`)
  }

}
