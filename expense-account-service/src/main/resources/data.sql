INSERT INTO account (account_id, name, id_user, is_visible) VALUES
  (1L,'kontoTestowe',1L, true);


INSERT INTO color (color_id, color) VALUES
    (1L,'czerwony');

INSERT INTO category (category_id,id_user,is_income, name, color_id) VALUES
    (1L,1L,true,'kategoriaTestowa',1L);

INSERT INTO subcategory (subcategory_id,name,category_id) VALUES
    (1L,'podkategoriaTestowa',1L);

INSERT INTO expence (id_user,expence_id, amount, date, note, type, account_id, subcategory_id) VALUES
    (1L,1L, 1000, '2015-12-17', 'notkaTestowa', 0, 1L, 1L);