-- Kustutame vana 'liisa' kasutaja, et vältida konflikti
DELETE FROM users WHERE username = 'liisa';

-- Lisame kasutaja 'liisa' parooliga 'parool123' (räsitud) ja rolliga 'admin'
INSERT INTO users (username, password, role)
VALUES ('liisa', '$2a$10$RAnl9LP9DtE0QCbi2B7gie0eWm7CASlvn2ytTxcg2XVbBzehPKoTW', 'admin');