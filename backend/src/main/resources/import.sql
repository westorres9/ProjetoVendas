INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Anakin', 'Skywalker', 'anakin@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Bob', 'Blue', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO tb_role (authority) VALUES ('ROLE_SELLER');
INSERT INTO tb_role (authority) VALUES ('ROLE_MANAGER');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);


INSERT INTO tb_team (name) VALUES ('Santander');
INSERT INTO tb_team (name) VALUES ('PicPay');
INSERT INTO tb_team (name) VALUES ('Bradesco');

INSERT INTO tb_seller (name) values ('Anakin');
INSERT INTO tb_seller (name) values ('Luke');
INSERT INTO tb_seller (name) values ('Padawan');
INSERT INTO tb_seller (name) values ('Padme');
INSERT INTO tb_seller (name) values ('Kal-El');
INSERT INTO tb_seller (name) values ('Logan');
INSERT INTO tb_seller (name) values ('Barry Allen');

INSERT INTO tb_team_seller(team_id, seller_id) values (1,1);
INSERT INTO tb_team_seller(team_id, seller_id) values (2,2);
INSERT INTO tb_team_seller(team_id, seller_id) values (3,3);
INSERT INTO tb_team_seller(team_id, seller_id) values (1,4);
INSERT INTO tb_team_seller(team_id, seller_id) values (2,5);
INSERT INTO tb_team_seller(team_id, seller_id) values (3,6);
INSERT INTO tb_team_seller(team_id, seller_id) values (1,7);

INSERT INTO tb_sales(visited,deals,amount,date) VALUES (121,67,18196.0,'2022-06-16');
INSERT INTO tb_sales(visited,deals,amount,date) VALUES (26,14,4255.0,'2022-06-14');
INSERT INTO tb_sales(visited,deals,amount,date) VALUES (55,42,13249.0,'2022-06-14');
INSERT INTO tb_sales(visited,deals,amount,date) VALUES (73,65,20751.0,'2022-06-10');
INSERT INTO tb_sales(visited,deals,amount,date) VALUES (47,25,7318.0,'2022-06-04');
INSERT INTO tb_sales(visited,deals,amount,date) VALUES (72,60,15608.0,'2022-06-03');
INSERT INTO tb_sales(visited,deals,amount,date) VALUES (97,68,8901.0,'2022-06-03');

INSERT INTO tb_seller_sale(seller_id, sale_id) VALUES (1,1);
INSERT INTO tb_seller_sale(seller_id, sale_id) VALUES (2,2);
INSERT INTO tb_seller_sale(seller_id, sale_id) VALUES (3,3);
INSERT INTO tb_seller_sale(seller_id, sale_id) VALUES (4,4);
INSERT INTO tb_seller_sale(seller_id, sale_id) VALUES (5,5);
INSERT INTO tb_seller_sale(seller_id, sale_id) VALUES (6,6);
INSERT INTO tb_seller_sale(seller_id, sale_id) VALUES (7,7);


