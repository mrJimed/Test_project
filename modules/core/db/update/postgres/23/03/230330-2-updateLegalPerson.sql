alter table PROJECT_LEGAL_PERSON rename column deleted_by to deleted_by__u54678 ;
alter table PROJECT_LEGAL_PERSON rename column delete_ts to delete_ts__u08460 ;
alter table PROJECT_LEGAL_PERSON rename column updated_by to updated_by__u02204 ;
alter table PROJECT_LEGAL_PERSON rename column update_ts to update_ts__u80541 ;
alter table PROJECT_LEGAL_PERSON rename column created_by to created_by__u14975 ;
alter table PROJECT_LEGAL_PERSON rename column create_ts to create_ts__u69525 ;
alter table PROJECT_LEGAL_PERSON rename column version to version__u89506 ;
alter table PROJECT_LEGAL_PERSON alter column version__u89506 drop not null ;
