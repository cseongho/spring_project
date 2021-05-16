-- 생성자 Oracle SQL Developer Data Modeler 20.4.0.374.0801
-- 위치:        2021-04-27 14:09:16 KST
-- 사이트:      Oracle Database 11g
-- 유형:      Oracle Database 11g
-- predefined type, no DDL - MDSYS.SDO_GEOMETRY
-- predefined type, no DDL - XMLTYPE

DROP TABLE category CASCADE CONSTRAINT PURGE;
DROP TABLE member CASCADE CONSTRAINT PURGE;
DROP TABLE site       CASCADE CONSTRAINT PURGE;

DROP SEQUENCE seq_member;
DROP SEQUENCE seq_category;
DROP SEQUENCE seq_site;

CREATE SEQUENCE seq_member   START WITH 1 INCREMENT BY 1 NOCACHE;
CREATE SEQUENCE seq_category   START WITH 1 INCREMENT BY 1 NOCACHE;
CREATE SEQUENCE seq_site         START WITH 1 INCREMENT BY 1 NOCACHE;

CREATE TABLE category (
    no         NUMBER(10) NOT NULL,
    name       VARCHAR2(40) NOT NULL,
    member_no  NUMBER(10) NOT NULL
);

ALTER TABLE category ADD CONSTRAINT category_pk PRIMARY KEY ( no );

CREATE TABLE member (
    no   NUMBER(10) NOT NULL,
    id   VARCHAR2(15) NOT NULL,
    pwd  VARCHAR2(255) NOT NULL,
    email VARCHAR2(30) NOT NULL
);

ALTER TABLE member ADD CONSTRAINT member_pk PRIMARY KEY ( no );

CREATE TABLE site (
    no           NUMBER(10) NOT NULL,
    title        VARCHAR2(100) NOT NULL,
    link         VARCHAR2(500) NOT NULL,
    content      CLOB NOT NULL,
    category_no  NUMBER(10) NOT NULL
);

ALTER TABLE site ADD CONSTRAINT site_pk PRIMARY KEY ( no );

ALTER TABLE category
    ADD CONSTRAINT category_member_fk FOREIGN KEY ( member_no )
        REFERENCES member ( no );

ALTER TABLE site
    ADD CONSTRAINT site_category_fk FOREIGN KEY ( category_no )
        REFERENCES category ( no );

-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             0
-- ALTER TABLE                              5
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
