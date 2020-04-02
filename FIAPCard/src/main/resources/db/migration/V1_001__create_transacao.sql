CREATE TABLE TB_TRANSACAO (
  id integer NOT NULL AUTO_INCREMENT,
  aluno_id integer NOT NULL,
  autorizadora varchar(20),
  valor decimal,
  data timestamp DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_AlunoTransacao FOREIGN KEY (aluno_id) REFERENCES TB_ALUNO(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
