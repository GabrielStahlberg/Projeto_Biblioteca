create table usuarios(
    id_user number primary key,
    usuario varchar(50) not null,
    login varchar(15) unique,
    senha varchar(15) not null
);

insert into usuarios(id_user, usuario, login, senha)values(1, 'Gabriel Stahlberg', 'gabriel', 'gabriel');
insert into usuarios(id_user, usuario, login, senha)values(2, 'Administrador', 'admin', 'admin');

select * from usuarios;

select count(*) from usuarios where login = 'gabriel' and senha = 'gabriel';
select usuario from usuarios where login = 'gabriel' and senha = 'gabriel';

commit;