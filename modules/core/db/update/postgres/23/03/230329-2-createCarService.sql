alter table PROJECT_CAR_SERVICE add constraint FK_PROJECT_CAR_SERVICE_ON_CITY foreign key (CITY_ID) references PROJECT_CITY(ID);
create index IDX_PROJECT_CAR_SERVICE_ON_CITY on PROJECT_CAR_SERVICE (CITY_ID);