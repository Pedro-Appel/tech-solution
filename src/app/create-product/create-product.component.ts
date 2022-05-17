import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/product.model';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.scss']
})
export class CreateProductComponent {

  @Output() aoCriar = new EventEmitter<any>();

  constructor(private service: ProductService, private router: Router) { }

  public name: string;
  public fornecedor: string;
  public price: string;
  @Input() public token: string = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgVGVjaFNvbHV0aW9uIiwic3ViIjoiMTIzZTQ1NjctZTg5Yi0xMmQzLWE0NTYtNTU2NjQyNDQxMjY1IiwiaWF0IjoxNjUyODE1NTAwLCJleHAiOjE2NTI5MDE5MDB9.-_opfqjvsmCME0C0EGyYRCWtuvFF6fL72_Hf6ym2Oh4"

  cadastrar(){
    const vEmitir: Product = {name: this.name, fornecedor: this.fornecedor, price: this.price}
    console.log(this.token)

    this.service.adicionar(vEmitir, this.token).subscribe(resultado => {
      console.log(resultado)
      this.router.navigateByUrl('productTable')
    })
  }
}
