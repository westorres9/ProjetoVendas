INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Ana', 'Blue', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Bob', 'Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Anakin', 'Skywalker', 'anakin@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Luke', 'Skywalker', 'luke@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Kale', 'El', 'kalel@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Odd', 'Mandrill', 'odd@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


INSERT INTO tb_role (authority) VALUES ('ROLE_SELLER');
INSERT INTO tb_role (authority) VALUES ('ROLE_MANAGER');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 1);


INSERT INTO tb_team (name, user_id) VALUES ('Santander',2);
INSERT INTO tb_team (name ,user_id) VALUES ('PicPay', 2);
INSERT INTO tb_team (name, user_id) VALUES ('Bradesco', 2);

INSERT INTO tb_team_seller(team_id, user_id) VALUES (1,1); 
INSERT INTO tb_team_seller(team_id, user_id) VALUES (2,4); 
INSERT INTO tb_team_seller(team_id, user_id) VALUES (2,5); 
INSERT INTO tb_team_seller(team_id, user_id) VALUES (3,6); 
INSERT INTO tb_team_seller(team_id, user_id) VALUES (3,7); 


INSERT INTO tb_sales(visited,deals,amount,date,user_id) VALUES (121,67,18196.0,'2022-06-16',1);
INSERT INTO tb_sales(visited,deals,amount,date,user_id) VALUES (26,14,4255.0,'2022-06-14',1);
INSERT INTO tb_sales(visited,deals,amount,date,user_id) VALUES (55,42,13249.0,'2022-06-14',1);
INSERT INTO tb_sales(visited,deals,amount,date,user_id) VALUES (73,65,20751.0,'2022-06-10',1);
INSERT INTO tb_sales(visited,deals,amount,date,user_id) VALUES (47,25,7318.0,'2022-06-04',1);
INSERT INTO tb_sales(visited,deals,amount,date,user_id) VALUES (72,60,15608.0,'2022-06-03',1);
INSERT INTO tb_sales(visited,deals,amount,date,user_id) VALUES (97,68,8901.0,'2022-06-03',1);


