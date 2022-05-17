import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/login.mode';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private urlBack = "/backend/auth"

  constructor() { }

  async signIn(username: string, password: string): Promise<string>{
    var myHeaders = new Headers;
    myHeaders.append("content-type", "application/json")
    return await fetch(this.urlBack, {body: JSON.stringify({username: username, password: password}), method: 'POST', headers: myHeaders})
    .then((res) => res.json())
    .then((res) => res.token)
  }
}
