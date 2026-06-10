# GülShop

GülShop est une plateforme e-commerce fullstack construite avec Java Spring Boot, Angular, PostgreSQL, Docker et GitHub Actions.

## Objectif du projet

Construire un projet portfolio professionnel, maintenable, sécurisé, testé, dockerisé et déployable.

## MVP

- Inscription utilisateur
- Connexion avec JWT
- Rôles CUSTOMER et ADMIN
- Catalogue produits
- Détail produit
- Recherche simple
- Filtre par catégorie
- Panier
- Checkout simulé
- Historique des commandes
- Administration simple des produits, catégories, stocks et commandes

## V2

- Filtres avancés
- Wishlist
- Profil utilisateur
- Gestion des adresses
- Avis produits
- Marques
- Promotions
- Gestion utilisateurs admin

## Production-ready

- Paiement réel ou simulation avancée
- Emails transactionnels
- Audit admin
- Statistiques avancées
- Internationalisation français / anglais / arabe
- Déploiement cloud

## Stack technique

### Backend

- Java 21
- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- Flyway
- OpenAPI / Swagger
- Actuator / Micrometer

### Frontend

- Angular
- TypeScript
- Reactive Forms
- Angular Router
- Guards
- HTTP Interceptors

### DevOps

- Git
- GitHub
- Docker
- Docker Compose
- GitHub Actions
- CI/CD

## Architecture cible

Le projet sera construit en monolithe modulaire.

Modules principaux :

- Authentification
- Utilisateurs
- Catalogue
- Panier
- Commandes
- Administration

## Stratégie Git

- main : branche stable
- develop : branche de développement
- feature/* : nouvelles fonctionnalités
- fix/* : corrections

## Statut

Projet en cours de construction.

## Structure du repository

```text
gulshop/
├── backend/
├── frontend/
├── docs/
└── docker/
```

- `backend` : application Java Spring Boot
- `frontend` : application Angular
- `docs` : documentation projet
- `docker` : configuration Docker complémentaire

## Lancer PostgreSQL en local

Prérequis :

- Docker
- Docker Compose

Commande :

```bash
docker compose up -d
```

## API catalogue

### Lister les produits

```bash
GET /api/products?page=0&size=10
```

### Rechercher un produit

```bash
GET /api/products?search=casque&page=0&size=10
```

### Filtrer par catégorie

```bash
GET /api/products?category=electronique&page=0&size=10
```

### Trier les produits

Prix croissant :

```bash
GET /api/products?page=0&size=10&sort=price,asc
```

Prix décroissant :

```bash
GET /api/products?page=0&size=10&sort=price,desc
```

Nom alphabétique :

```bash
GET /api/products?page=0&size=10&sort=name,asc
```

### Détail produit

```bash
GET /api/products/casque-bluetooth
```
## Documentation API

Swagger UI :

```bash
http://localhost:8080/swagger-ui.html
```

OpenAPI JSON :

```bash
http://localhost:8080/v3/api-docs
```
