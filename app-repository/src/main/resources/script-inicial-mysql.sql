CREATE TABLE 'USER' (
	'id' INT NOT NULL,
	'username' VARCHAR(50) NOT NULL,
	'password' VARCHAR(100) NOT NULL,
	PRIMARY KEY ('id'),
	UNIQUE INDEX 'username' ('username')
)
COMMENT='tabala de usuarios de sistema'
COLLATE='latin1_spanish_ci'
;
CREATE TABLE 'ROL' (
	'id' INT(10) NOT NULL AUTO_INCREMENT,
	'role' VARCHAR(50) NOT NULL COLLATE 'latin1_spanish_ci',
	PRIMARY KEY ('id') USING BTREE,
	UNIQUE INDEX 'FK_ROL_ROLE' ('role') USING BTREE
)
COLLATE='latin1_spanish_ci'
ENGINE=InnoDB
;
CREATE TABLE 'users roles' (
	'user_id' INT(10) NOT NULL,
	'rol_id' INT(10) NOT NULL,
	PRIMARY KEY ('user_id', 'rol_id') USING BTREE,
	INDEX 'FK__USERS_ROLES_USER' ('rol_id') USING BTREE,
	CONSTRAINT 'FK__USERS_ROLES_ROL' FOREIGN KEY ('user_id') REFERENCES 'user' ('id') ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT 'FK__USERS_ROLES_USER' FOREIGN KEY ('rol_id') REFERENCES 'rol' ('id') ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='tabla de roles por usuario'
COLLATE='latin1_spanish_ci'
ENGINE=InnoDB
;
INSERT INTO 'educacionit-bootcamp-vicente-lopez'.'rol' ('role') VALUES ('USER');
SELECT LAST_INSERT_ID();
SELECT 'id', 'role' FROM 'educacionit-bootcamp-vicente-lopez'.'rol' WHERE  'id'=1;
INSERT INTO 'educacionit-bootcamp-vicente-lopez'.'rol' ('role') VALUES ('ADMIN');
SELECT LAST_INSERT_ID();
SELECT 'id', 'role' FROM 'educacionit-bootcamp-vicente-lopez'.'rol' WHERE  'id'=2;
INSERT INTO 'educacionit-bootcamp-vicente-lopez'.'rol' ('role') VALUES ('OFICIAL');
SELECT LAST_INSERT_ID();
SELECT 'id', 'role' FROM 'educacionit-bootcamp-vicente-lopez'.'rol' WHERE  'id'=3;

INSERT INTO 'educacionit-bootcamp-vicente-lopez'.'user' ('username', 'password') VALUES ('administrador', '$2y$10$NkGPqwdh6VZhCcS9zaWlLeI0Tz2vuOIyC4PL.D1lvLvvTPMc5piuu');
SELECT LAST_INSERT_ID();
SELECT 'id', 'username', 'password' FROM 'educacionit-bootcamp-vicente-lopez'.'user' WHERE  'id'=1;
INSERT INTO 'educacionit-bootcamp-vicente-lopez'.'user' ('username', 'password') VALUES ('usuario', '$2y$10$NkGPqwdh6VZhCcS9zaWlLeI0Tz2vuOIyC4PL.D1lvLvvTPMc5piuu');
SELECT LAST_INSERT_ID();
SELECT 'id', 'username', 'password' FROM 'educacionit-bootcamp-vicente-lopez'.'user' WHERE  'id'=2;
INSERT INTO 'educacionit-bootcamp-vicente-lopez'.'user' ('username', 'password') VALUES ('oficial', '$2y$10$NkGPqwdh6VZhCcS9zaWlLeI0Tz2vuOIyC4PL.D1lvLvvTPMc5piuu');
SELECT LAST_INSERT_ID();
SELECT 'id', 'username', 'password' FROM 'educacionit-bootcamp-vicente-lopez'.'user' WHERE  'id'=3;

SELECT 'id', LEFT('username', 256) FROM 'educacionit-bootcamp-vicente-lopez'.'user' GROUP BY 'id', 'username' ORDER BY 'username' LIMIT 10000;
SELECT 'id', LEFT('role', 256) FROM 'educacionit-bootcamp-vicente-lopez'.'rol' GROUP BY 'id', 'role' ORDER BY 'role' LIMIT 10000;
INSERT INTO 'educacionit-bootcamp-vicente-lopez'.'users roles' ('user_id', 'rol_id') VALUES (1, 2);
SELECT 'user_id', 'rol_id' FROM 'educacionit-bootcamp-vicente-lopez'.'users roles' WHERE  'user_id'=1 AND 'rol_id'=2;
SELECT 'id', LEFT('username', 256) FROM 'educacionit-bootcamp-vicente-lopez'.'user' GROUP BY 'id', 'username' ORDER BY 'username' LIMIT 10000;
SELECT 'id', LEFT('role', 256) FROM 'educacionit-bootcamp-vicente-lopez'.'rol' GROUP BY 'id', 'role' ORDER BY 'role' LIMIT 10000;
INSERT INTO 'educacionit-bootcamp-vicente-lopez'.'users roles' ('user_id', 'rol_id') VALUES (2, 1);
SELECT 'user_id', 'rol_id' FROM 'educacionit-bootcamp-vicente-lopez'.'users roles' WHERE  'user_id'=2 AND 'rol_id'=1;
SELECT 'id', LEFT('username', 256) FROM 'educacionit-bootcamp-vicente-lopez'.'user' GROUP BY 'id', 'username' ORDER BY 'username' LIMIT 10000;
SELECT 'id', LEFT('role', 256) FROM 'educacionit-bootcamp-vicente-lopez'.'rol' GROUP BY 'id', 'role' ORDER BY 'role' LIMIT 10000;
INSERT INTO 'educacionit-bootcamp-vicente-lopez'.'users roles' ('user_id', 'rol_id') VALUES (3, 3);
SELECT 'user_id', 'rol_id' FROM 'educacionit-bootcamp-vicente-lopez'.'users roles' WHERE  'user_id'=3 AND 'rol_id'=3;