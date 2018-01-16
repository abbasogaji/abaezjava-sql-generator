# ABEAZ-CRUD JAVA SQL GENERATOR API
This is a custom built sql generator which returns string value in-form of SQL commands for basic CRUD fuctions
C - Create
R - read
U - Update
D - delete


#### Download the jar file and import it into your project
* [AbaezSqlGenerator.jar](https://github.com/abbasogaji/abaezjava-sql-generator/releases/download/v1.0/abaezSqlGenerator.jar) - Version 1.0 
  - <strong>import</strong> abaezcorp.sql.generator.*; to your java file;

-----------------------------------------------
-----------------------------------------------

### How to use the SQL generator

1. Firstly, create an object of the SqlGenerator() class
2. Secondly, Call the table() method with argument representing the Database Table Name
#### 3. for a select operation;
 - chain the select() method to table(),  to select all column data or select('column1', 'column2') to select the specific column data needed
 - you can also add a WHERE clause by chaining the where() method to the select() method in question.
 - the where method accepts only two parameters, the 'column name' and the 'column value' respectively.
 - finally chain the get() method at the end
 ----------------------------------------------------
    * Example :
    | data = sql.table("users").select().where("username", "abcd").get(); |
	| data = sql.table("users").select("first_name", "last_name").where("username", "abcd").get(); |
 
#### 4. for a insert operation;
 - chain the insert() method to table(),  the insert() method acccepts unlimited string arguments representing the column Name
 - now chain the values() method to the insert() method in question, the values() method acccepts unlimited string arguments representing the columnValue
 - finally chain the get() method at the end
----------------------------------------------------
    * Example :
    | data = sql.table("users").insert("name", "age").values("abbas", "20", "male").get(); |

#### 5. for the update opertaion
 - chain the update() method to table(),  the update() method acccepts unlimited string arguments representing the column Name
 - now chain the to() method to the insert() method in question, the to() method acccepts unlimited string arguments representing the columnValue
 - finally chain the get() method at the end
  ----------------------------------------------------
    * Example :
    | data = sql.table("Books").update("name", "age", "sex").to("abbas", "20", "male").where("username", "abase96").get(); | 

#### 6. for the delete operation
- chain the delete() method to table(),  the insert() method acccepts unlimited string arguments representing the columnName
- now chain the where() method to the insert() method in question, the where() method acccepts unlimited string arguments representing the SQL WHERE condition
- finally chain the get() method at the end
   ----------------------------------------------------
    * Example :
    | data = sql.table("users").delete().where("abbas", "male").get(); |    

#### Constraits
    * No mutlipe WHERE conditions
    * No JOIN CLAUSES
    * No ORDER BY CLAUSES