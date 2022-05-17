import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private urlBack = '/backend/product';
  private listDeProducts: Product[];


  constructor(private httpClient: HttpClient) {
    this.listDeProducts = [];
   }

  async todosProdutos(): Promise<Product[]>{
    return await fetch(this.urlBack, {method: 'GET'})
    .then((res) => res.json())
    .then((res) => res.content)
    // return this.httpClient.get(`${this.urlBack}`)
  }
  get jogos(){
    return this.listDeProducts;
  }
  adicionar(product :Product, token: string): Observable<any>{
    var myHeaders = new Headers;
    myHeaders.append("content-type", "application/json")
    return this.httpClient.post<any>(this.urlBack, product,{headers: {"content-type": "application/json", "Authorization": `Bearer ${token}`}})
  }
}
