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
  adicionar(product :Product): Observable<Product>{
    return this.httpClient.post<Product>(this.urlBack, product,
      {
        headers:
        {
          'Access-Control-Allow-Origin': '*',
          "Access-Control-Allow-Methods": "GET, OPTIONS, POST, PUT"
        }
      });
  }
}
