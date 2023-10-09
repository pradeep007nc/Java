import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
})
export class LoginFormComponent {
  @Output() onSubmitLoginEvent = new EventEmitter();
  @Output() onSubmitRegisterEvent = new EventEmitter();

  active: string = 'login';
  firstName: string = '';
  lastName: string = '';
  login: string = '';
  password: string = '';

  onTabLogin() {
    this.active = 'login';
  }

  onTabRegister() {
    this.active = 'register';
  }

  onSubmitLogin(): void {
    this.onSubmitLoginEvent.emit({
      login: this.login,
      password: this.password,
    });
  }

  onSubmitRegister() {
    this.onSubmitLoginEvent.emit({
      firstName: this.firstName,
      lastName: this.lastName,
      login: this.login,
      password: this.password,
    });
  }
}
