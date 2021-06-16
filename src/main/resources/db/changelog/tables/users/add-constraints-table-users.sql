--liquibase formatted sql

--changeset egor:2021-06-16-create-table-users

ALTER TABLE users ADD CONSTRAINT role_fk FOREIGN KEY(role) REFERENCES roles(id); 

-- rollback ALTER TABLE users DROP CONSTRAINT role_fk;