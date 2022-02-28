/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication3;

/**
 *
 * @author Acer
 */
import java.sql.*; 


public class DB_Con {
    public static void main(String[] args){
         getConnection();
    }
   public static Connection getConnection (){
   Connection connect = null;
   String url = "jdbc:mysql://localhost:3306/student?SSL=true";
   String username = "root";
   String password = "#vanlakhan0105#ISXM";
   try{
   Class.forName("com.mysql.cj.jdbc.Driver");
   connect = (Connection) DriverManager.getConnection(url,username,password);
   System.out.println("s sam let");
   }catch(ClassNotFoundException | SQLException e){
    System.out.println("s tr phit");
    
   }
   return connect;
   }
}
