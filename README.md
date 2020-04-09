# 35SCJ_Spring
MBA Full Stack - Spring

Projeto FIAPCard

1 - É necessário criar o diretório ~/fiapcard, pois é neste diretório que será criado o arquivo do banco de dados H2.

2 - É necessário executar a aplicação FIAPCardBatch e depois derrubá-la, para o banco de dados não ficar lockado. Essa aplicação irá pegar as informações que estão no arquivo alunos.txt que está no resources do projeto e popular a tabela TB_ALUNO.

3 - Executar a aplicação FIAPCard, esta é a api rest que disponibilizará os end-points de Alunos e Transações. Foram criadas algumas transações fakes por script no arquivo V1_001__create_transacao.sql do db.migration do flyway.
