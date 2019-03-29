package com.stackroute;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    static Connection con;
    public static void main( String[] args )
    {
        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb","root","Root@123");
            //create statement object
            System.out.println("got connected");

            Statement stmt=con.createStatement();

            PreparedStatement preparedStatement = con.prepareStatement("select * from customer where name=?");
            preparedStatement.setString(1,args[0]);
            ResultSet rs=preparedStatement.executeQuery();


            //execute query
//            ResultSet rs=stmt.executeQuery("select * from customer where name=?");
            //process result
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getInt(3));

        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
