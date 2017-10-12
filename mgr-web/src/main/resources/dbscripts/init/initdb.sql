-- Init Employee Table
insert into employee (email, password, display_name, gender, phone, is_locked, is_super, status) values ('simon@sap.com', 'Initial1', 'Simon Huang', 0, '138XXXX1234', 0, 1, 0);
insert into employee (email, password, display_name, gender, phone, is_locked, is_super, status) values ('echo@126.com', 'Initial1', 'Liang Echo', 1, '137YYYY4321', 0, 1, 0);

-- Init Role Table
insert into role (id, name, description) values (1, 'admin', 'Administrator');

-- Init Rule Table
insert into authorization_rule (id, resource, permission) values (1, 'project', 2);

-- Init Role_Rule Table
insert into role_rule (role_id, rule_id) values (1, 1);