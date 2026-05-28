# GülShop — Cadrage projet

## Vision courte

GülShop est une plateforme e-commerce fullstack construite comme un projet portfolio professionnel.

Le projet doit montrer des compétences solides en Java Spring Boot, Angular, PostgreSQL, Docker, GitHub Actions et architecture applicative.

## Périmètre MVP

- Authentification JWT
- Rôles CUSTOMER et ADMIN
- Catalogue produits
- Détail produit
- Recherche simple
- Filtre par catégorie
- Panier
- Checkout simulé
- Historique des commandes
- Administration simple

## Périmètre V2

- Wishlist
- Profil utilisateur
- Adresses
- Avis produits
- Marques
- Promotions
- Filtres avancés

## Périmètre production-ready

- Paiement réel ou simulation avancée
- Emails transactionnels
- Audit admin
- Statistiques avancées
- Internationalisation
- Déploiement cloud

## Rôles utilisateurs

### CUSTOMER

Utilisateur client.

Il peut consulter les produits, gérer son panier, passer une commande simulée et consulter son historique.

### ADMIN

Utilisateur administrateur.

Il peut gérer les produits, catégories, stocks et commandes.

## Modules principaux

- Auth
- Users
- Catalog
- Cart
- Orders
- Admin

## Risques de complexité

- Ne pas partir sur les microservices en V1.
- Ne pas complexifier les variantes produit trop tôt.
- Ne pas ajouter le paiement réel au MVP.
- Ne pas commencer l’internationalisation complète dès le début.
- Ne pas coder sans tests ni documentation.