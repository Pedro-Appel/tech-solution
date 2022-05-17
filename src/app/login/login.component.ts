import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent{
  public password: string;
  public username: string;

  @Output() public token: string;


  constructor(private service: UserService,  private router: Router) { }

  async logar(){
    var res = await this.service.signIn(this.username, this.password)
    console.log(res)
    this.token = res;
    this.router.navigateByUrl("productTable")
  }
}
