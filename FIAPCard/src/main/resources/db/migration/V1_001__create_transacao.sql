CREATE TABLE if not exists TB_TRANSACAO (
  id integer NOT NULL AUTO_INCREMENT,
  aluno_id integer NOT NULL,
  autorizadora varchar(20),
  valor decimal,
  PRIMARY KEY (id),
  CONSTRAINT FK_AlunoTransacao FOREIGN KEY (aluno_id) REFERENCES TB_ALUNO(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM TB_TRANSACAO;

INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(1, 'MASTER_CARD', 30.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(5, 'VISA', 125.25);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(87, 'CIELO', 100.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(102, 'MASTER_CARD', 15.99);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(116, 'MASTER_CARD', 21.25);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(148, 'MASTER_CARD', 89.99);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(187, 'CIELO', 54.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(234, 'MASTER_CARD', 30.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(435, 'VISA', 124.65);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(102, 'VISA', 20.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(1, 'MASTER_CARD', 12.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(5, 'VISA', 35.99);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(543, 'MASTER_CARD', 49.99);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(654, 'MASTER_CARD', 258.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(543, 'CIELO', 34.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(1, 'MASTER_CARD', 50.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(87, 'MASTER_CARD', 325.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(102, 'VISA', 73.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(148, 'VISA', 25.50);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(1, 'VISA', 36.59);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(345, 'CIELO', 110.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(34, 'MASTER_CARD', 56.12);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(22, 'MASTER_CARD', 96.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(88, 'VISA', 99.99);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(14, 'MASTER_CARD', 100);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(98, 'CIELO', 30.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(70, 'CIELO', 40.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(34, 'MASTER_CARD', 49.99);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(5, 'MASTER_CARD', 52.50);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(10, 'MASTER_CARD', 50.00);
INSERT INTO TB_TRANSACAO(aluno_id, autorizadora, valor) VALUES(100, 'MASTER_CARD', 100.00);

