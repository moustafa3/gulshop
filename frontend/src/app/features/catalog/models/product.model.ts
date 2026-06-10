import { Category } from './category.model';

export interface Product {
  id: string;
  name: string;
  slug: string;
  description: string | null;
  price: number;
  stockQuantity: number;
  available: boolean;
  category: Category;
}