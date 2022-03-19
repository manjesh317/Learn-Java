package com.man.jdbc;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/employee_database";
        int rowsAffected;
        try {
            //Establish connection object
            Connection connection= DriverManager.getConnection(url,"root","ROOT");
            //create sql statement object to send to the database
            Statement statement=connection.createStatement();
            //INSERT
            rowsAffected=statement.executeUpdate("insert into employee_database.employees_tbl (id,name,dept,salary) "
            +"values(1000,'Hello','sales',4000);");
            System.out.println("Executed an insert statement - rows affected: "+rowsAffected);
            //UPADTE
            rowsAffected=statement.executeUpdate("UPDATE employee_database.employees_tbl set salary=5500 where id=600;");
            System.out.println("Executed an update statement - rows affected: "+rowsAffected);
            //SELECT
            //Execute the statement object
            ResultSet resultSet=statement.executeQuery("SELECT * FROM employee_database.employees_tbl");

            //process the result
            while (resultSet.next()){
                System.out.println(resultSet.getString("name")+" : "+resultSet.getString("salary"));
            }
            //DELETE
            //this java query will delete all data from table but this statement is run in db workspace in safe mode
            rowsAffected=statement.executeUpdate("DELETE from employee_database.employees_tbl");
            System.out.println("Executed a delete statement - rows affected: "+rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error while insertion...");
        }
    }
}
