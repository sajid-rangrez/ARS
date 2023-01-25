package com.project.jdbc;


import java.sql.*;

public class pro1 {
//	 private static FileInputStream inputStream;
     private static Connection connection;
     private static Statement stat;
     private static ResultSet result;
     static void close() throws SQLException {
          if(result != null){
              result.close();
          }
          if(stat != null){
              stat.close();
          }
          if(connection != null){
              connection.close();
          }
         
     }
 public static void main(String[] args) {
     try {


         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
         stat = connection.createStatement();
         result = stat.executeQuery("SELECT * from STUDENTS ");
         while(result.next()){
             System.out.println(result.getString(1)+ " "+ result.getString(2)+ " "+ result.getString(3)+ " "+ result.getString(4)+ " "+ result.getString(5)+ " "+ result.getString(6)+ " "+ result.getString(7));
         }
//         PrintTables.DisplayStudents(result);


     }catch (SQLException e) {
         e.printStackTrace();
     }
     


 }
}
