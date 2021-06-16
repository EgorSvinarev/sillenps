--liquibase formatted sql

--changeset egor:2021-06-16-create-table-roles

CREATE TABLE roles(
	id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(30)
);

-- rollback DROP TABLE roles;