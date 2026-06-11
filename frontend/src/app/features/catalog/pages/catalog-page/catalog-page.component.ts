import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CatalogService } from '../../services/catalog.service';
import { Product } from '../../models/product.model';

@Component({
  selector: 'app-catalog-page',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './catalog-page.component.html',
  styleUrl: './catalog-page.component.scss',
})
export class CatalogPageComponent implements OnInit {
  products: Product[] = [];
  loading = false;
  errorMessage = '';

  constructor(private readonly catalogService: CatalogService) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  private loadProducts(): void {
    this.loading = true;
    this.errorMessage = '';

    this.catalogService.getProducts({ page: 0, size: 10 }).subscribe({
      next: (response) => {
        this.products = response.content;
        this.loading = false;
      },
      error: () => {
        this.errorMessage = 'Impossible de charger les produits.';
        this.loading = false;
      },
    });
  }
}