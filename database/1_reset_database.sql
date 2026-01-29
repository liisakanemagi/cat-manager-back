-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA IF EXISTS bmx CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA bmx
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA bmx TO postgres;
GRANT ALL ON SCHEMA bmx TO PUBLIC;