insert INTO tb_stock_class (code, class_type, description) VALUES  (3, 'ON', 'ORDINARIA');
insert INTO tb_stock_class (code, class_type, description) values (4, 'PN', 'PREFERENCIAL');
insert INTO tb_stock_class (code, class_type, description) values (11, 'UNIT', 'UNITARIA');


insert INTO tb_active (NAME, QTY_ON, QTY_PN, TICKET, CODE) values ('TAESA', NULL, NULL, 'TAEE', 3);
insert INTO tb_active (NAME, QTY_ON, QTY_PN, TICKET, CODE) values ('TAESA', NULL, NULL, 'TAEE', 4);
insert INTO tb_active (NAME, QTY_ON, QTY_PN, TICKET, CODE) values ('TAESA', 3, 2, 'TAEE', 11);
insert INTO tb_active (NAME, QTY_ON, QTY_PN, TICKET, CODE) values ('VALE', NULL, NULL, 'VALE', 3);
insert INTO tb_active (NAME, QTY_ON, QTY_PN, TICKET, CODE) values ('BITCOIN', NULL, NULL, 'BTC', NULL);

INSERT INTO tb_investment (DATE, QUANTITY, type_investment, type_operation, value, id_active) values (STR_TO_DATE('21/10/2021','%d/%m/%Y'), 50, 'STOCK', 'BUY', 52.35, 1);
INSERT INTO tb_investment (DATE, QUANTITY, type_investment, type_operation, value, id_active) values (STR_TO_DATE('01/02/2020','%d/%m/%Y'), 50, 'STOCK', 'BUY', 63.15, 1);
INSERT INTO tb_investment (DATE, QUANTITY, type_investment, type_operation, value, id_active) values (STR_TO_DATE('10/02/2021','%d/%m/%Y'), 40, 'STOCK', 'SELL', 65.50, 1);
INSERT INTO tb_investment (DATE, QUANTITY, type_investment, type_operation, value, id_active) values (STR_TO_DATE('10/02/2020','%d/%m/%Y'), 40, 'STOCK', 'BUY', 40.20, 2);
INSERT INTO tb_investment (DATE, QUANTITY, type_investment, type_operation, value, id_active) values (STR_TO_DATE('10/05/2021','%d/%m/%Y'), 20, 'STOCK', 'SELL', 35.80, 2);
INSERT INTO tb_investment (DATE, QUANTITY, type_investment, type_operation, value, id_active) values (STR_TO_DATE('10/09/2021','%d/%m/%Y'), 80, 'STOCK', 'BUY', 67.80, 4);
INSERT INTO tb_investment (DATE, QUANTITY, type_investment, type_operation, value, id_active) values (STR_TO_DATE('15/10/2021','%d/%m/%Y'), 90, 'STOCK', 'BUY', 17.80, 3);
INSERT INTO tb_investment (DATE, QUANTITY, type_investment, type_operation, value, id_active) values (STR_TO_DATE('05/01/2021','%d/%m/%Y'), 1, 'CRYPTO', 'BUY', 1700.80, 5);
INSERT INTO tb_investment (DATE, QUANTITY, type_investment, type_operation, value, id_active) values (STR_TO_DATE('10/03/2021','%d/%m/%Y'), 40, 'STOCK', 'SELL', 75.86, 4);
