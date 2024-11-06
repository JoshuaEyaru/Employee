package com.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    // database connection credentials
    String db_url = "jdbc:mysql://localhost:3306/example";
    String db_user = "root";
    String db_pass = "";

    public Employee selectEmployeeByName(String name){
        
        // emp represents tha data to return from this method
        Employee emp = null;

        // our query to execute on the database
        String query = "SELECT * FROM employees WHERE empName=?";

        try (Connection conn = DriverManager.getConnection(db_url, db_user, db_pass);
            // use prepared statements here to prevent sql injection
            // the preparedStatement method on connection objects returns a preparedStatement 
            PreparedStatement ps = conn.prepareStatement(query);){ 

            // since query had a place hold '?' we set it's 
            ps.setString(1, name);

            // Execute the query and get the ResultSet in try-with-resources
            try (ResultSet rs = ps.executeQuery()){

                // use 'next()' method of ResultSet to check if there is data and advance the cursor from that row if available
                if (rs.next()){

                    // create an Employee populated with data from the ResultSet
                    // we use the column names here, but we could also use the column index.
                    emp = new Employee(
                        rs.getInt("empId"),
                        rs.getString("empName"),
                        rs.getString("empTitle")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       return emp;
    }

    public List<Employee> selectAllEmployees(){
            // here we use simple statements since there are no parameters for the query
            
            
            
            // this method returns a collection (List) of Employee objects
            ArrayList<Employee> eList = new ArrayList<Employee>();
            String query = "SELECT * FROM employees";

            // get a connection to the database represented by a connection object
            try (Connection conn = DriverManager.getConnection(db_url, db_user, db_pass);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query)){

                // we use a while loop since we exoect multiple records to be returned
                while (rs.next()){
                    eList.add(
                        new Employee(
                            rs.getInt(1), 
                            rs.getString(2),
                            rs.getString(3)
                        ));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        
        return eList;
    }

    // Other code below...

}
