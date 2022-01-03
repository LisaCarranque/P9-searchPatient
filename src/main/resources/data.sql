

use P9;
insert ignore into patient (uuid, address, birthdate, genre, phone, firstname, lastname) values
  ('cd23fd55-d832-4890-b5b6-0a7a63987c14', '1509 Culver St', '1980-10-02', 'F', '841-874-6512', 'leonie', 'ki');
commit;
insert ignore into patient (uuid, address, birthdate, genre, phone, firstname, lastname) values
  ('33e814e4-0f8f-4fb3-a65d-6dd4908d16bf', '1519 Culver St', '1980-10-02', 'M', '841-874-6512', 'leon', 'ki');
commit;
insert ignore into patient (uuid, address, birthdate, genre, phone, firstname, lastname) values
  ('cd23fd55-d832-4890-b5b6-0a7a63987c12', '1519 Culver St', '1981-10-02', 'M', '841-874-6512', 'john', 'ki');
commit;