--sqlplus
--sys/sys as sysdba


-- 创建系统帐户
create user ibzrt
  identified by ibzrt
  default tablespace USERS
  temporary tablespace TEMP
  profile DEFAULT
  quota unlimited on USERS;
-- Grant/Revoke role privileges
grant connect to ibzrt;
-- Grant/Revoke system privileges
grant alter session to ibzrt;
grant alter user to ibzrt;
grant create any trigger to ibzrt;
grant create database link to ibzrt;
grant create library to ibzrt;
grant create materialized view to ibzrt;
grant create procedure to ibzrt;
grant create public database link to ibzrt;
grant create public synonym to ibzrt;
grant create sequence to ibzrt;
grant create session to ibzrt;
grant create synonym to ibzrt;
grant create table to ibzrt;
grant create trigger to ibzrt;
grant create type to ibzrt;
grant create view to ibzrt;
grant debug connect session to ibzrt;
grant unlimited tablespace to ibzrt;