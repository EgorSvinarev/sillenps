--liquibase formatted sql

--changeset egor:2021-06-13-create-table-users

CREATE TABLE users (
	id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(30) NOT NULL,
	password CHAR(60) NOT NULL,
	email VARCHAR(120) NOT NULL,
	role INT UNSIGNED NOT NULL,
	name VARCHAR(20),
	surname VARCHAR(20),
	gender INT UNSIGNED
)