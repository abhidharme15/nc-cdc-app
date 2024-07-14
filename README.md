# Up and running with CDC (Change Data Capture) using Debezium

## Overview
If we consider requirement such as migrating data from source database to target database then CDC using debezium could be an ideal choice rather than DBlink. In this particular example 
source DB is MongoDB and target DB is Postgres. Debezium tool will make use of Kafka to capture the changes from source DB to target DB.

## Steps to setup nc-cdc-app

```shell
# Build the application
mvn clean install

# Build a dependent jdbc sink docker image
cd ..
docker build -t debezium/connect-jdbc:2.0 .

# Build a nc-cdc-app docker image
docker build -t abhidharme/nc-cdc-app .

# Build and run whole application using docker-compose
docker compose up --build -d
```

## Init data in databases

Check contents of the MongoDB database:

```shell
docker compose exec mongodb bash -c 'mongo -u $MONGODB_USER -p $MONGODB_PASSWORD --authenticationDatabase admin inventory --eval "db.customers.find()"'

{ "_id" : NumberLong(1001), "first_name" : "Sally", "last_name" : "Thomas", "email" : "sally.thomas@acme.com" }
{ "_id" : NumberLong(1002), "first_name" : "George", "last_name" : "Bailey", "email" : "gbailey@foobar.com" }
{ "_id" : NumberLong(1003), "first_name" : "Edward", "last_name" : "Walker", "email" : "ed@walker.com" }
{ "_id" : NumberLong(1004), "first_name" : "Anne", "last_name" : "Kretchmar", "email" : "annek@noanswer.org" }
```

Verify that the PostgreSQL database has the same content:

```shell
docker compose exec postgres bash -c 'psql -U $POSTGRES_USER $POSTGRES_DB -c "select * from customers"'
 last_name |  id  | first_name |         email
-----------+------+------------+-----------------------
 Thomas    | 1001 | Sally      | sally.thomas@acme.com
 Bailey    | 1002 | George     | gbailey@foobar.com
 Walker    | 1003 | Edward     | ed@walker.com
 Kretchmar | 1004 | Anne       | annek@noanswer.org
(4 rows)
```

## Notes
Please refer below readme for additional information,
https://github.com/debezium/debezium-examples/tree/main/unwrap-mongodb-smt#readme
