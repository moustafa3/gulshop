import { Routes } from '@angular/router';

import { CatalogPageComponent } from './features/catalog/pages/catalog-page/catalog-page.component';

export const routes: Routes = [
  {
    path: '',
    component: CatalogPageComponent,
  },
  {
    path: '**',
    redirectTo: '',
  },
];