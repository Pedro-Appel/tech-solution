import { Component, EventEmitter, OnInit, Output } from '@angular/core';
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

  cadastrar(){
    const vEmitir: Product = {name: this.name, fornecedor: this.fornecedor, price: this.price}
    console.log(vEmitir)
    this.service.adicionar(vEmitir).subscribe(resultado => {
      console.log(resultado)
      this.router.navigateByUrl('extrato')
    })
  }
}
