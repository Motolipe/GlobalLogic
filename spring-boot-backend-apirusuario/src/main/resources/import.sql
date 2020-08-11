insert into usuarios (id, name, email, password, create_at, modified, enabled) values ('17169623', 'Fernanda', 'fernanda@gmail.com', 'fernanda321', now(),now(), true);
insert into telefonos (number_phone, citycode, contrycode,usuario_id) values (75, '9', '56','17169623');
insert into telefonos (number_phone, citycode, contrycode,usuario_id) values (7213213, '9', '56','17169623');
insert into telefonos (number_phone, citycode, contrycode,usuario_id) values (721, '9', '56','17169623');

insert into USUARIOS_TELEFONOS (usuario_id, TELEFONOS_NUMBER_PHONE) values ('17169623', 75);
insert into USUARIOS_TELEFONOS (usuario_id, TELEFONOS_NUMBER_PHONE) values ('17169623', 7213213);



