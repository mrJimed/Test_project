-- begin PROJECT_CAR_SERVICE
create table PROJECT_CAR_SERVICE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    ADDRESS varchar(255) not null,
    PHONE_NUMBER varchar(255) not null,
    CITY_ID uuid not null,
    --
    primary key (ID)
)^
-- end PROJECT_CAR_SERVICE
-- begin PROJECT_CITY
create table PROJECT_CITY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PHONE_CODE varchar(255) not null,
    IS_DEFAULT_CITY boolean,
    --
    primary key (ID)
)^
-- end PROJECT_CITY
-- begin PROJECT_EMPLOYEE
create table PROJECT_EMPLOYEE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LAST_NAME varchar(255) not null,
    FIRST_NAME varchar(255) not null,
    BIRTHDAY date not null,
    SALARY decimal(19, 2) not null,
    EMAIL varchar(255) not null,
    CAR_SERVICE_ID uuid,
    --
    primary key (ID)
)^
-- end PROJECT_EMPLOYEE
-- begin PROJECT_REPAIR
create table PROJECT_REPAIR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CAR_SERVICE_ID uuid,
    EMPLOYEE_ID uuid,
    --
    primary key (ID)
)^
-- end PROJECT_REPAIR
-- begin PROJECT_LEGAL_PERSON
create table PROJECT_LEGAL_PERSON (
    ID uuid,
    --
    NAME varchar(255) not null,
    FIELD_ACTIVITY varchar(255) not null,
    --
    primary key (ID)
)^
-- end PROJECT_LEGAL_PERSON
-- begin PROJECT_CLIENT
create table PROJECT_CLIENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    EMAIL varchar(255) not null,
    --
    primary key (ID)
)^
-- end PROJECT_CLIENT
-- begin PROJECT_PHYSICAL_PERSON
create table PROJECT_PHYSICAL_PERSON (
    ID uuid,
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    AGE integer not null,
    --
    primary key (ID)
)^
-- end PROJECT_PHYSICAL_PERSON
-- begin TEST_CLIENT_LINK
create table TEST_CLIENT_LINK (
    CAR_SERVICE_ID uuid,
    CLIENT_ID uuid,
    primary key (CAR_SERVICE_ID, CLIENT_ID)
)^
-- end TEST_CLIENT_LINK
