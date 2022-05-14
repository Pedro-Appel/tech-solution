import { Component, Input, OnInit } from '@angular/core';
import { Product } from '../model/product.model';

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.scss']
})
export class ProductTableComponent implements OnInit {
  @Input() public products: Product[] = [];
  constructor() { }

  ngOnInit(): void {
  }

}
