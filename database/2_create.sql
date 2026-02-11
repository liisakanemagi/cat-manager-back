ALTER TABLE cats
    ADD CONSTRAINT fk_cats_status
        FOREIGN KEY (status_code) REFERENCES cat_statuses(status_code);