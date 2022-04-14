import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatchpokemonComponent } from './components/catchpokemon/catchpokemon.component';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PokeboxComponent } from './components/pokebox/pokebox.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'catch', component: CatchpokemonComponent },
  { path: 'pokemon', component: PokeboxComponent},
  { path: '**', redirectTo: ''}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
