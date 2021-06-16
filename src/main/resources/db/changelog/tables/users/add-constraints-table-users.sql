--liquibase formatted sql

--changeset egor:2021-06-16-add_role-fk_constraint

ALTER TABLE users ADD CONSTRAINT role_fk FOREIGN KEY(role) REFERENCES roles(id); 

-- rollback ALTER TABLE users DROP CONSTRAINT role_fk;

--changeset egor:2021-06-16-add_gender-fk_constraint

ALTER TABLE users ADD CONSTRAINT gender_fk FOREIGN KEY(gender) REFERENCES genders(id); 

-- rollback ALTER TABLE users DROP CONSTRAINT gender_fk;