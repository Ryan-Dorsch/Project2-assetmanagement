import { Component } from '@angular/core';
import { TokenStorageService } from './services/token-storage.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private roles: string[] = [];
  isLoggedIn = false;
  showUserIndex = false;
  showManagerIndex = false;
  showSignup = false;
  username?: string;
  title = 'Pokehub';

  constructor(private tokenStorageService: TokenStorageService) { }
  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showUserIndex = this.roles.includes('ROLE_USER');
      this.showManagerIndex = this.roles.includes('ROLE_MANAGER');

      this.username = user.username;
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }

  setSignup(): void {
    this.showSignup = !this.showSignup;
  }


}
