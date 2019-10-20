insert into `ROLE` values ('0', 'ADMIN');
insert into `ROLE` values ('1', 'TEACHER');
insert into `ROLE` values ('2', 'STUDENT');

-- contrasena 123
insert into `USER` (IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED) values ('bm0567', 'alumno', 'apellidos', '$2a$04$xfqwcWepMIM7/gHiDoWt2.wxMr2rZQTG1.gwBpFL4qDXSGXO9tZNm', 'alumn@upm', false);
insert into `USER` (IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED) values ('15500384v', 'profesor', 'apellidos', '$2a$04$xfqwcWepMIM7/gHiDoWt2.wxMr2rZQTG1.gwBpFL4qDXSGXO9tZNm', 'profesor@upm', false);
insert into `USER` (IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED) values ('aa', 'admin', 'apellidos', '$2a$04$xfqwcWepMIM7/gHiDoWt2.wxMr2rZQTG1.gwBpFL4qDXSGXO9tZNm', 'admin@upm', false);

insert into `USER_ROLE` values ('1', '2');
insert into `USER_ROLE` values ('2', '1');
insert into `USER_ROLE` values ('3', '0');