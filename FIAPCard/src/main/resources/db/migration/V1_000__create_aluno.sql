CREATE TABLE ALUNO (
  id integer NOT NULL AUTO_INCREMENT,
  nome varchar(200) NOT NULL,
  cpf long NOT NULL,
  data_criacao timestamp DEFAULT NULL,
  data_atualizacao timestamp DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
