import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CatalogService } from '../../services/catalog.service';
import { Product } from '../../models/product.model';
import { Category } from '../../models/category.model';

@Component({
  selector: 'app-catalog-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './catalog-page.component.html',
  styleUrl: './catalog-page.component.scss',
})
export class CatalogPageComponent implements OnInit {
  products: Product[] = [];
  categories: Category[] = [];

  searchTerm = '';
  selectedCategory = '';

  loading = false;
  errorMessage = '';

  constructor(private readonly catalogService: CatalogService) {}

  ngOnInit(): void {
    this.loadCategories();
    this.loadProducts();
  }

  searchProducts(): void {
    this.loadProducts();
  }

  filterByCategory(): void {
    this.loadProducts();
  }

  clearFilters(): void {
    this.searchTerm = '';
    this.selectedCategory = '';
    this.loadProducts();
  }

  private loadCategories(): void {
    this.catalogService.getCategories(0, 20).subscribe({
      next: (response) => {
        this.categories = response.content;
      },
      error: () => {
        this.errorMessage = 'Impossible de charger les catégories.';
      },
    });
  }

  private loadProducts(): void {
    this.loading = true;
    this.errorMessage = '';

    this.catalogService
      .getProducts({
        page: 0,
        size: 10,
        search: this.searchTerm.trim() || undefined,
        category: this.selectedCategory || undefined,
      })
      .subscribe({
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