insert into role values ('0', 'administrador');
insert into role values ('1', 'profesor');
insert into role values ('2', 'alumno');

insert into user values ('0', 'alumno', '', '123', 'alumn@upm');
insert into user values ('1', 'profesor', '', '123', 'profesor@upm');
insert into user values ('2', 'admin', '', '123', 'admin@upm');

insert into USER_ROLE values ('0', '2');
insert into USER_ROLE values ('1', '1');
insert into USER_ROLE values ('2', '0');