 create table leitores(
    leitor_id number(6) primary key,
    leitor_prontuario varchar(20),            -- Ou deixar um valor default, caso seja usuário externo e não tenha o prontuário.
    leitor_nome varchar(50) not null,
    leitor_rg_estado varchar(10) not null,
    leitor_rg varchar(20) not null,
    leitor_uf varchar(5),
    leitor_cidade varchar(100),
    leitor_endereco varchar(100) not null,
    leitor_email varchar(50),
    leitor_telefone varchar(50) not null,
    leitor_status_emprestimo number(1,0) default 1,   -- 1 = TRUE(ATIVO)    0 = FALSE(SUSPENSO)
    leitor_data_nasc date not null,
    cat_leitor_cod varchar(15) not null,
    
    constraint cat_leitor_fk foreign key(cat_leitor_cod) references categoria_leitor(cat_leitor_cod) on delete cascade,
    constraint nome_unico unique(leitor_nome),
    constraint email_unico unique(leitor_email),
    constraint prontuario_unico unique(leitor_prontuario)
);

create sequence leitor_seq
increment by 10
start with 10
maxvalue 100000
nocache
nocycle;

create table categoria_leitor(
    cat_leitor_cod varchar(15) primary key,
    cat_leitor_desc varchar(256) not null,
    cat_leitor_max_dias number(2) not null,

    constraint dias_check check(cat_leitor_max_dias > 6)
);

create table categoria_obra(
    cat_obra_cod varchar(10) primary key,
    cat_obra_desc varchar(256) not null
);

create table obras(
    obra_isbn varchar(20) primary key,
    obra_editora varchar(50) not null,
    obra_titulo varchar(50) not null,
    obra_num_edicao number,
    obra_qtde_total number default 1,
    data_publ date,
    cat_obra_cod varchar(10) not null,
    
    constraint cat_obra_fk foreign key(cat_obra_cod) references categoria_obra(cat_obra_cod) on delete cascade
);

create table autores(
    autor_nro number primary key,
    autor_nome varchar(256) not null,
    obra_isbn varchar(20) not null
);

create sequence autores_seq
increment by 1
start with 1
maxvalue 100000
nocache
nocycle;

create table palavras_chave(
    palavra_id number primary key,
    palavra varchar(100) not null,
    obra_isbn varchar(20) not null
);

create sequence palavras_chave_seq
increment by 1
start with 1
maxvalue 100000
nocache
nocycle;

create table exemplares(
    exemplar_id number primary key,
    exemplar_status varchar(20) default 'Disponivel',
    obra_isbn varchar(20) not null,
    
    constraint obra_isbn_fk foreign key(obra_isbn) references obras(obra_isbn) on delete cascade
);

create sequence exemplar_seq
increment by 1
start with 1
maxvalue 100000
nocache
nocycle;

create table funcionarios(
    func_id number primary key,
    func_nome varchar(50) not null
);

create sequence funcionario_seq
increment by 1
start with 1
maxvalue 100000
nocache
nocycle;

create table emprestimos(
    emp_id number(6) primary key,
    emp_data date not null,
    emp_data_real_dev date,
    emp_data_prev_dev date not null,
    exemplar_id number not null,
    leitor_id number(6) not null,
    func_id number not null,
    
    foreign key(leitor_id) references leitores(leitor_id) on delete cascade,
    foreign key(exemplar_id) references exemplares(exemplar_id) on delete cascade,
    foreign key(func_id) references funcionarios(func_id) on delete cascade
);

insert into categoria_leitor(cat_leitor_cod, cat_leitor_desc, cat_leitor_max_dias)
values ('SERV', 'Servidores', 20);

insert into categoria_leitor(cat_leitor_cod, cat_leitor_desc, cat_leitor_max_dias)
values ('ALUN', 'Aluno', 15);

insert into funcionarios(func_id, func_nome)values(FUNCIONARIO_SEQ.nextval, 'Luana');
	insert into funcionarios(func_id, func_nome)values(FUNCIONARIO_SEQ.nextval, 'Letícia');

insert into categoria_obra(cat_obra_cod, cat_obra_desc)values('LIV', 'Livro');
insert into categoria_obra(cat_obra_cod, cat_obra_desc)values('REV', 'Revista');
insert into categoria_obra(cat_obra_cod, cat_obra_desc)values('JOR', 'Jornal');
insert into categoria_obra(cat_obra_cod, cat_obra_desc)values('ART', 'Artigo');
insert into categoria_obra(cat_obra_cod, cat_obra_desc)values('GIB', 'Gibi');

insert into palavras_chave(palavra_id, palavra, obra_isbn)values(PALAVRAS_CHAVE_SEQ.nextval, 'romance', '147-74-147-0554-1');
insert into palavras_chave(palavra_id, palavra, obra_isbn)values(PALAVRAS_CHAVE_SEQ.nextval, 'fada', '258-85-258-8888-2');
insert into palavras_chave(palavra_id, palavra, obra_isbn)values(PALAVRAS_CHAVE_SEQ.nextval, 'conto', '258-85-258-8888-2');

insert into autores(autor_nro, autor_nome, obra_isbn)values(autores_seq.nextval, 'Miguel de Cervantes', '147-74-147-0554-1');
insert into autores(autor_nro, autor_nome, obra_isbn)values(autores_seq.nextval, 'Gabriel', '147-74-147-0554-1');
insert into autores(autor_nro, autor_nome, obra_isbn)values(autores_seq.nextval, 'Charles Perrault', '258-85-258-8888-2');

insert into obras(obra_isbn, obra_editora, obra_titulo, obra_num_edicao, obra_qtde_total, data_publ, cat_obra_cod)values('147-74-147-0554-1', 'Francisco de Robles', 'Dom Quixote', 1, 10, sysdate, 'LIV');
insert into obras(obra_isbn, obra_editora, obra_titulo, obra_num_edicao, obra_qtde_total, data_publ, cat_obra_cod)values('258-85-258-8888-2', '�?tica', 'O Pequeno Polegar', 2, 10, sysdate, 'LIV');

insert into exemplares(exemplar_id, obra_isbn)values(EXEMPLAR_SEQ.nextval, '258-85-258-8888-2');

insert into leitores
(leitor_id, leitor_prontuario, leitor_nome, leitor_rg_estado, leitor_rg, leitor_uf, leitor_cidade, leitor_endereco, leitor_email, 
leitor_telefone, leitor_status_emprestimo, leitor_data_nasc, cat_leitor_cod)
values(leitor_seq.nextval, '1710111', 'Gabriel', 'SP', '11.111.111-1', 'SP', 'Araraquara', 'Rua Um, 1, Jardim Primeiro', 'ga@gmail.com',
'(16)11111111', 1, '02/09/1998', 'ALUN');

insert into leitores
(leitor_id, leitor_prontuario, leitor_nome, leitor_rg_estado, leitor_rg, leitor_uf, leitor_cidade, leitor_endereco, leitor_email, 
leitor_telefone, leitor_status_emprestimo, leitor_data_nasc, cat_leitor_cod)
values(leitor_seq.nextval, '1711222', 'Marcos', 'SP', '22.222.222-2', 'SP', 'Rincão', 'Rua Dois, 2, Jardim Secundo', 'ma@gmail.com',
'(16)22222222', 1, '21/04/1998', 'ALUN');

insert into leitores
(leitor_id, leitor_prontuario, leitor_nome, leitor_rg_estado, leitor_rg, leitor_uf, leitor_cidade, leitor_endereco, leitor_email, 
leitor_telefone, leitor_status_emprestimo, leitor_data_nasc, cat_leitor_cod)
values(leitor_seq.nextval, '1713333', 'Dênis', 'SC', '33.333.333-3', 'SC', 'Florianópolis', 'Rua Três, 3, Jardim Terceiro', 'de@ifsp.edu.br',
'(16)33333333', 1, '11/06/1985', 'SERV');

insert into leitores
(leitor_id, leitor_prontuario, leitor_nome, leitor_rg_estado, leitor_rg, leitor_uf, leitor_cidade, leitor_endereco, leitor_email, 
leitor_telefone, leitor_status_emprestimo, leitor_data_nasc, cat_leitor_cod)
values(leitor_seq.nextval, '1714421', 'João', 'RJ', '44.444.444-4', 'RJ', 'Niteroi', 'Rua Quatro, 4, Jardim Quarto', 'jo@ifsp.edu.br',
'(16)44448757', 1, '13/08/1992', 'SERV');

