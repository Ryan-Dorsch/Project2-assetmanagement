import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../model/pokemon';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const baseUrl = 'http://localhost:8080/api';
@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) { }

  getUserPokemon(id: any): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(`${baseUrl}/users/${id}/pokemon`);
  }

  getPokemonData(id: any): Observable<any> {
    return this.http.get(`${baseUrl}/pokemon/data/${id}`)
  }

  addUserPokemon(id: any, data: any): Observable<any> {
    return this.http.post(`${baseUrl}/users/${id}/pokemon`, 
    {
      data
    });
  }

  updatePokemonLocation(pokemon: Pokemon): Observable<any>{
    return this.http.put(`${baseUrl}/pokemon/${pokemon.id}`,
      {
          id: pokemon.id,
          nickname: pokemon.nickname,
          location: pokemon.location
        
      });
    }

}
