import { Injectable } from '@angular/core';
import { API_CONFIG } from './api.config';

@Injectable({
providedIn: 'root',
})
export class ApiUrlService {
getBaseUrl(): string {
return API_CONFIG.baseUrl;
}

buildUrl(path: string): string {
const cleanPath = path.startsWith('/') ? path : `/${path}`;

return `${API_CONFIG.baseUrl}${cleanPath}`;
}
}
