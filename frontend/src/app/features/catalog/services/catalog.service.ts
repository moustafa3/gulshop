import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { ApiUrlService } from '../../../core/services/api-url.service';
import { PageResponse } from '../../../shared/models/page-response.model';
import { Category } from '../models/category.model';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root',
})
export class CatalogService {
  constructor(
    private readonly http: HttpClient,
    private readonly apiUrlService: ApiUrlService
  ) {}

  getCategories(page = 0, size = 10): Observable<PageResponse<Category>> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size);

    return this.http.get<PageResponse<Category>>(
      this.apiUrlService.buildUrl('/categories'),
      { params }
    );
  }

  getProducts(options?: {
    page?: number;
    size?: number;
    search?: string;
    category?: string;
    sort?: string;
  }): Observable<PageResponse<Product>> {
    let params = new HttpParams()
      .set('page', options?.page ?? 0)
      .set('size', options?.size ?? 10);

    if (options?.search) {
      params = params.set('search', options.search);
    }

    if (options?.category) {
      params = params.set('category', options.category);
    }

    if (options?.sort) {
      params = params.set('sort', options.sort);
    }

    return this.http.get<PageResponse<Product>>(
      this.apiUrlService.buildUrl('/products'),
      { params }
    );
  }

  getProductBySlug(slug: string): Observable<Product> {
    return this.http.get<Product>(
      this.apiUrlService.buildUrl(`/products/${slug}`)
    );
  }
}