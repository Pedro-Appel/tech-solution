import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent{

 @Output() aoLogar = new EventEmitter<any>();

  public password: string;
  public username: string;


  constructor(private service: UserService,  private router: Router) { }

  logar(){
    this.service.signIn(this.username, this.password)
    this.router.navigateByUrl("productTable")
  }
}
