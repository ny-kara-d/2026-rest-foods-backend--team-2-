INSERT INTO menu_category (menu_id, chefs_choice, category_vegetarian, category_meat, category_fish) VALUES
('cccccccc-cccc-cccc-cccc-000000000001', 'Bruschetta',   'Caprese Salad',    'Chicken Wings', 'Shrimp Cocktail'),
('cccccccc-cccc-cccc-cccc-000000000002', 'Ribeye Steak', 'Mushroom Risotto', 'Lamb Chops',    'Grilled Salmon'),
('cccccccc-cccc-cccc-cccc-000000000003', 'Tiramisu',     'Fruit Sorbet',     'Panna Cotta',   'N/A');

INSERT INTO menu_item (item_id, chefs_choice, vegetarian, meat, fish, menu_category_id) VALUES
('dddddddd-dddd-dddd-dddd-000000000001', true,  false, false, false, 'cccccccc-cccc-cccc-cccc-000000000001'),
('dddddddd-dddd-dddd-dddd-000000000002', false, true,  false, false, 'cccccccc-cccc-cccc-cccc-000000000001'),
('dddddddd-dddd-dddd-dddd-000000000003', false, false, true,  false, 'cccccccc-cccc-cccc-cccc-000000000001'),
('dddddddd-dddd-dddd-dddd-000000000004', false, false, false, true,  'cccccccc-cccc-cccc-cccc-000000000001'),
('dddddddd-dddd-dddd-dddd-000000000005', true,  false, true,  false, 'cccccccc-cccc-cccc-cccc-000000000002'),
('dddddddd-dddd-dddd-dddd-000000000006', false, true,  false, false, 'cccccccc-cccc-cccc-cccc-000000000002'),
('dddddddd-dddd-dddd-dddd-000000000007', false, false, true,  false, 'cccccccc-cccc-cccc-cccc-000000000002'),
('dddddddd-dddd-dddd-dddd-000000000008', false, false, false, true,  'cccccccc-cccc-cccc-cccc-000000000002'),
('dddddddd-dddd-dddd-dddd-000000000009', true,  true,  false, false, 'cccccccc-cccc-cccc-cccc-000000000003'),
('dddddddd-dddd-dddd-dddd-000000000010', false, true,  false, false, 'cccccccc-cccc-cccc-cccc-000000000003');

INSERT INTO restaurant_table (table_id, chairs) VALUES
('11111111-1111-1111-1111-111111111111', 2),
('22222222-2222-2222-2222-222222222222', 4),
('33333333-3333-3333-3333-333333333333', 4),
('44444444-4444-4444-4444-444444444444', 6),
('55555555-5555-5555-5555-555555555555', 8);

INSERT INTO reservation (
    reservation_id,
    starting_time,
    ending_time,
    amount_of_persons,
    phone_number,
    nameof_person,
    restaurant_table_table_id
) VALUES
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '2026-07-10 18:00:00', '2026-07-10 20:00:00', 2, '0791111111', 'Max Muster', '11111111-1111-1111-1111-111111111111'),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '2026-07-11 19:00:00', '2026-07-11 21:00:00', 4, '0792222222', 'Lena Keller', '22222222-2222-2222-2222-222222222222'),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa3', '2026-06-12 18:30:00', '2026-06-12 20:00:00', 3, '0793333333', 'Timo Frei', '33333333-3333-3333-3333-333333333333'),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa4', '2026-06-12 20:30:00', '2026-06-12 22:00:00', 2, '0794444444', 'Sara Meier', '33333333-3333-3333-3333-333333333333'),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa5', '2026-06-13 17:00:00', '2026-06-13 19:00:00', 5, '0795555555', 'Jonas Roth', '44444444-4444-4444-4444-444444444444'),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa6', '2026-06-13 19:30:00', '2026-06-13 21:30:00', 6, '0796666666', 'Mia Huber', '44444444-4444-4444-4444-444444444444'),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa7', '2026-06-14 18:00:00', '2026-06-14 20:00:00', 8, '0797777777', 'Noah Graf', '55555555-5555-5555-5555-555555555555');
