import { Component, Input, OnInit } from '@angular/core';
import { Product } from '../model/product.model';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.scss']
})
export class ProductTableComponent implements OnInit {

  @Input() public products: Product[] = [];

  constructor(private service: ProductService) { }

  async ngOnInit(): Promise<void> {
    this.products = await this.service.todosProdutos();
  }

}
