-- liquibase formatted sql

--changeset egor:2021-06-16-create-table-genders

CREATE TABLE genders(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(30)
);

-- rollback DROP TABLE genders;