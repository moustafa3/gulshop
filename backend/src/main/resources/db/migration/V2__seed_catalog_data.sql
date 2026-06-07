INSERT INTO categories (id, name, slug, description, enabled, created_at, updated_at)
VALUES
('11111111-1111-1111-1111-111111111111', 'Vêtements', 'vetements', 'Mode homme, femme et enfant', true, NOW(), NOW()),
('22222222-2222-2222-2222-222222222222', 'Électronique', 'electronique', 'Produits électroniques et accessoires', true, NOW(), NOW()),
('33333333-3333-3333-3333-333333333333', 'Maison', 'maison', 'Articles pour la maison', true, NOW(), NOW());

INSERT INTO products (id, category_id, name, slug, description, price, stock_quantity, enabled, created_at, updated_at)
VALUES
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '11111111-1111-1111-1111-111111111111', 'T-shirt basique blanc', 't-shirt-basique-blanc', 'T-shirt simple et confortable en coton.', 19.99, 50, true, NOW(), NOW()),
('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', '11111111-1111-1111-1111-111111111111', 'Veste légère noire', 'veste-legere-noire', 'Veste légère pour la mi-saison.', 59.99, 20, true, NOW(), NOW()),
('cccccccc-cccc-cccc-cccc-cccccccccccc', '22222222-2222-2222-2222-222222222222', 'Casque Bluetooth', 'casque-bluetooth', 'Casque sans fil avec bonne autonomie.', 89.99, 35, true, NOW(), NOW()),
('dddddddd-dddd-dddd-dddd-dddddddddddd', '22222222-2222-2222-2222-222222222222', 'Clavier mécanique', 'clavier-mecanique', 'Clavier mécanique compact pour développeurs.', 79.99, 15, true, NOW(), NOW()),
('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', '33333333-3333-3333-3333-333333333333', 'Lampe de bureau', 'lampe-de-bureau', 'Lampe moderne pour bureau ou chambre.', 34.99, 40, true, NOW(), NOW());
