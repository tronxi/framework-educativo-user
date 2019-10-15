insert into `ROLE` values ('0', 'ADMIN');
insert into `ROLE` values ('1', 'TEACHER');
insert into `ROLE` values ('2', 'STUDENT');

-- contrasena 123
insert into `USER` values ('0', 'alumno', '', '$2a$04$xfqwcWepMIM7/gHiDoWt2.wxMr2rZQTG1.gwBpFL4qDXSGXO9tZNm', 'alumn@upm');
insert into `USER` values ('1', 'profesor', '', '$2a$04$xfqwcWepMIM7/gHiDoWt2.wxMr2rZQTG1.gwBpFL4qDXSGXO9tZNm', 'profesor@upm');
insert into `USER` values ('2', 'admin', '', '$2a$04$xfqwcWepMIM7/gHiDoWt2.wxMr2rZQTG1.gwBpFL4qDXSGXO9tZNm', 'admin@upm');

insert into `USER_ROLE` values ('0', '2');
insert into `USER_ROLE` values ('1', '1');
insert into `USER_ROLE` values ('2', '0');