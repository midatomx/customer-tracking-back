CREATE DATABASE fecan;

USE fecan;

# ----------
# PROCEDURES
# ----------

INSERT INTO cartype(id, code, name, active)
VALUES (1, 'CD1', 'Nombre 1', true);
INSERT INTO cartype(id, code, name, active)
VALUES (2, 'CD2', 'Nombre 2', true);
INSERT INTO cartype(id, code, name, active)
VALUES (3, 'CD3', 'Nombre 3', true);
INSERT INTO cartype(id, code, name, active)
VALUES (4, 'CD4', 'Nombre 4', true);
INSERT INTO cartype(id, code, name, active)
VALUES (5, 'CD5', 'Nombre 5', true);
INSERT INTO cartype(id, code, name, active)
VALUES (6, 'CD6', 'Nombre 6', true);

SELECT *
FROM cartype;

# 1-REMOVE RECORD FROM cartype TABLE
DELIMITER $$
DROP PROCEDURE IF EXISTS remove_cartype$$
CREATE PROCEDURE remove_cartype(IN cartypeId LONG)
BEGIN
    DELETE
    FROM cartype AS ct
    WHERE ct.id = cartypeId;
END
$$

CALL remove_cartype(4);


# 2-REMOVE RECORD FROM prospect TABLE
INSERT INTO prospect (id, active, address, city, comments, email, firstname, lastname, name, phone, state,
                      cartype_id)
VALUES (1, true, 'Dirección', 'Ciudad', 'Estos con mis comentarios', 'migue@gmail.com', 'García', 'Martínez',
        'Miguel Angel', '5530555471', 'Estado', 7);
INSERT INTO prospect (id, active, address, city, comments, email, firstname, lastname, name, phone, state,
                      cartype_id)
VALUES (2, true, 'Dirección', 'Ciudad', 'Estos con mis comentarios', 'erick@gmail.com', 'García', 'Martínez',
        'Erick Tonatiuh', '5530555471', 'Estado', 7);
INSERT INTO prospect (id, active, address, city, comments, email, firstname, lastname, name, phone, state,
                      cartype_id)
VALUES (3, true, 'Dirección', 'Ciudad', 'Estos con mis comentarios', 'danna@gmail.com', 'García', 'Martínez',
        'Danna Citlalli', '5530555471', 'Estado', 7);
INSERT INTO prospect (id, active, address, city, comments, email, firstname, lastname, name, phone, state,
                      cartype_id)
VALUES (4, true, 'Dirección', 'Ciudad', 'Estos con mis comentarios', 'fer@gmail.com', 'García', 'Santiago',
        'Fernando', '5530555471', 'Estado', 7);
INSERT INTO prospect (id, active, address, city, comments, email, firstname, lastname, name, phone, state,
                      cartype_id)
VALUES (5, true, 'Dirección', 'Ciudad', 'Estos con mis comentarios', 'migue@gmail.com', 'David', '',
        'Jenn', '5530555471', 'Estado', 7);


SELECT *
FROM prospect;


DELIMITER $$
DROP PROCEDURE IF EXISTS remove_prospect$$
CREATE PROCEDURE remove_prospect(IN prospectId LONG)
BEGIN
    DELETE
    FROM prospect AS pp
    WHERE pp.id = prospectId;
END
$$

CALL remove_prospect(5);


# 3-RETURN ALL RECORDS FROM prospect TABLE
DELIMITER $$
DROP PROCEDURE IF EXISTS prospect_list$$
CREATE PROCEDURE prospect_list()
BEGIN
    SELECT *
    FROM prospect;
END
$$

CALL prospect_list();



# --------
# FUNCTION
# --------

# 2-RETURN NUMBER OF REGISTERED CUSTOMERS
DELIMITER $$
DROP FUNCTION IF EXISTS registered_customers$$
CREATE FUNCTION registered_customers()
    RETURNS INT UNSIGNED
    DETERMINISTIC
BEGIN
    DECLARE total INT UNSIGNED;
    SET total = (SELECT COUNT(*) AS INTERESTED_CUSTOMERS
                 FROM prospect);
    RETURN total;
END
$$

DELIMITER ;
SELECT registered_customers();


# --------
# TRIGGERS
# --------

# 1-UPDATE RECORDS WHEN COLUMN lastname is empty AND SET value 'X' IN prospect TABLE
DELIMITER $$
DROP TRIGGER IF EXISTS trigger_change_lastname_after_update$$
CREATE TRIGGER trigger_change_lastname_after_update
    BEFORE UPDATE
    ON prospect
    FOR EACH ROW
BEGIN
    IF (NEW.lastname IS NULL OR NEW.lastname = ' ') THEN
        set NEW.lastname = 'X';
    END IF;
END
$$

# 2-UPDATE RECORDS THAT'S HAVE COLUMN active = false to true IN cartype TABLE
DELIMITER $$
DROP TRIGGER IF EXISTS trigger_change_estatus_before_update$$
CREATE TRIGGER trigger_change_estatus_before_update
    BEFORE UPDATE
    ON cartype
    FOR EACH ROW
BEGIN
    IF NEW.active = false THEN
        set NEW.active = true;
    END IF;
END
$$


# --------
# VIEWS
# --------
DROP VIEW IF EXISTS tracked_prospect;

CREATE VIEW tracked_prospect AS
SELECT *
FROM prospect
WHERE active = false;

SELECT *
FROM tracked_prospect;
