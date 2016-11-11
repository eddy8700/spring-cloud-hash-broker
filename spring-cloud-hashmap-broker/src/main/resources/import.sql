insert into services (id, name, description, bindable) values (LOCALTIME, LOCALTIME, 'hashmap-service broker', true);
insert into plans (id, name, description, service_id) values (LOCALTIME, 'basic', 'Plan001', LOCALTIME);
