INSERT INTO USER (ID, NAME, EMAIL, PASSWORD, CREATED, MODIFIED, LAST_LOGIN, TOKEN, ISACTIVE) 
VALUES ('2e6b056c-aa89-4df6-a03e-3901cb905457','Juan Rodriguez', 'juan@rodriguez.org', 'Hunter2@', '2023-09-26', '2023-09-26', '2023-10-01', 'eyJraWQiOiJCQ0kiLCJhbGciOiJIUzI1NiJ9..jWH8JH9V8NZQ0FJQUi74uY7VRQkIWLgDcs74maKbAdg', TRUE);

INSERT INTO USER (ID, NAME, EMAIL, PASSWORD, CREATED, MODIFIED, LAST_LOGIN, TOKEN, ISACTIVE) 
VALUES ('2e6b056c-aa89-4df6-a03e-3901cb905458','Juan Perez', 'juan@perez.org', 'Hunter2@', '2023-10-26', '2023-10-26', '2023-10-26','eyJraWQiOiJCQ0kiLCJhbGciOiJIUzI1NiJ9..jWH8JH9V8NZQ0FJQUi74uY7VRQkIWLgDcs74maKbAff', TRUE);

INSERT INTO PHONE (ID, ID_USER, NUMBER, CITY_CODE, COUNTRY_CODE) 
VALUES ('2e6b056c-aa89-4df6-a03e-3901cb905459', '2e6b056c-aa89-4df6-a03e-3901cb905458', '+5699999999', '011', '02');

INSERT INTO PHONE (ID, ID_USER, NUMBER, CITY_CODE, COUNTRY_CODE) 
VALUES ('2e6b056c-aa89-4df6-a03e-3901cb905479', '2e6b056c-aa89-4df6-a03e-3901cb905458', '+5699999999', '011', '02');

INSERT INTO PHONE (ID, ID_USER, NUMBER, CITY_CODE, COUNTRY_CODE) 
VALUES ('2e6b056c-aa89-4df6-a03e-3901cb905460', '2e6b056c-aa89-4df6-a03e-3901cb905457', '+5699999999', '011', '02');