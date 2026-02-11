


INSERT INTO public.cats (id, name, status_code, birthday, weight, sex, chip_number, health_info, other_info, image_url, user_id) VALUES (default, 'Vello', 'MY_CAT', '2020-01-01', null, null, null, null, null, null, 2);

INSERT INTO public.cat_statuses (status_code, label) VALUES ('MY_CAT', 'Minu kiisu');
INSERT INTO public.cat_statuses (status_code, label) VALUES ('HOME', 'Kodu leidnud');
INSERT INTO public.cat_statuses (status_code, label) VALUES ('AVAILABLE', 'Otsib kodu');
INSERT INTO public.cat_statuses (status_code, label) VALUES ('BOOKED', 'Broneeritud');
INSERT INTO public.cat_statuses (status_code, label) VALUES ('DECEACED', 'Vikerkaare taga');
