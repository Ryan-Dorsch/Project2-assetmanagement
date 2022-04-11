import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatchpokemonComponent } from './components/catchpokemon/catchpokemon.component';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'catchpokemon', component: CatchpokemonComponent },
  { path: '**', redirectTo: ''}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
