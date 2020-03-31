CREATE TABLE TB_ALUNO (
  id integer NOT NULL AUTO_INCREMENT,
  nome varchar(200) NOT NULL,
  cpf bigint NOT NULL,
  created_date timestamp DEFAULT NULL,
  updated_date timestamp DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
