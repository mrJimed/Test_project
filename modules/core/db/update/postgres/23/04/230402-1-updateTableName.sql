CREATE OR REPLACE FUNCTION update_project_city_is_default_city()
RETURNS trigger AS
$TF$
BEGIN
    IF (NEW.is_default_city = true) THEN
UPDATE project_city
SET is_default_city = false
WHERE id <> NEW.id;
END IF;
RETURN NEW;
END;
$TF$
LANGUAGE plpgsql;


CREATE TRIGGER update_project_city_is_default_city_on_update_trigger
    BEFORE UPDATE OF is_default_city ON project_city
    FOR EACH ROW
    EXECUTE PROCEDURE update_project_city_is_default_city();


CREATE TRIGGER update_project_city_is_default_city_on_insert_trigger
    BEFORE INSERT ON project_city
    FOR EACH ROW
    EXECUTE PROCEDURE update_project_city_is_default_city();