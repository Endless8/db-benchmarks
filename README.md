# DB Benchmarks
Simple Java application to perform benchmarks to target POSTGRE Database.

## Description
This simple Java application performs a set of INSERT queries and SELECT queries and measures the time that passes between and operation and another, then prints to console the minimum, the maximum and the average time of all the queries, grouped by query type. The target table for benchmarks is automatically created by a script then it's automatically dropped at the end of benchmarks.

## Configuration file
The configuration file, under `/resources/configuration.properties`, contains the following properties
| Property name | Description |
| ------------- | ----------- |
| database.url | Contains the URL of Database host. |
| database.user | Username for the Database. |
| database.password | Password for the Database. |
| commit.frequency | Number of transactions between a commit and another. |
| insert.quantity | Number of INSERT queries to perform. |
| select.quantity | Number of SELECT queries to perform. |

## Description of the queries
The INSERT queries performed insert random generated values on each row, on each row a Person is inserted.
The script for the table creation is located under `/resources/create-benchmark-table.sql`

## Launching the application
Clone this repository and execute this command in the root folder:
```
mvn clean install
```
After that go in the `target` folder and execute for launching the application:
```
java -jar db-benchmarks-1.0-SNAPSHOT.jar
```
Alternatively copy `db-benchmarks-1.0-SNAPSHOT-jar-with-dependencies.jar` file and launch it wherever you want executing:
```
java -jar db-benchmarks-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Author

Edoardo Ciarrocchi