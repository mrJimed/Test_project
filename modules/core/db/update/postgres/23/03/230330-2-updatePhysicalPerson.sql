alter table PROJECT_PHYSICAL_PERSON rename column deleted_by to deleted_by__u94111 ;
alter table PROJECT_PHYSICAL_PERSON rename column delete_ts to delete_ts__u06408 ;
alter table PROJECT_PHYSICAL_PERSON rename column updated_by to updated_by__u89990 ;
alter table PROJECT_PHYSICAL_PERSON rename column update_ts to update_ts__u91280 ;
alter table PROJECT_PHYSICAL_PERSON rename column created_by to created_by__u22443 ;
alter table PROJECT_PHYSICAL_PERSON rename column create_ts to create_ts__u13498 ;
alter table PROJECT_PHYSICAL_PERSON rename column version to version__u87452 ;
alter table PROJECT_PHYSICAL_PERSON alter column version__u87452 drop not null ;
