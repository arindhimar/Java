/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpcrud;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Arin Dhimar
 */
public class TpCrud {
    Connection connection;
    
    public static void menu(){
        System.out.println("1 - insert");
        System.out.println("2 - delete");
        System.out.println("3 - update");
        System.out.println("4 - display");
        System.out.println("5 - exit");

    }
    
    public  void insert () throws SQLException {
        Scanner sc = new Scanner(System.in);
        String s1,s2,s3;
        
                connection = DriverManager.getConnection("jdbc:mysql://localhost/tpdb","root","");

        
        System.out.println("Enter name");
        s1 = sc.nextLine();
        
        System.out.println("Enter email");
        s2 = sc.nextLine();
        
        
        System.out.println("Enter password");
        s3 = sc.nextLine();
        
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `tptb`(`tname`, `temail`, `tpass`) VALUES ('"+s1+"','"+s2+"','"+s2+"')");
        
        preparedStatement.executeUpdate();
    }
    
    
    public  void update () throws SQLException {
        Scanner sc = new Scanner(System.in);
        String s1,s2,s3;
        int i1;
        
                connection = DriverManager.getConnection("jdbc:mysql://localhost/tpdb","root","");

                sc.nextLine();
                        System.out.println("Enter id");
        i1 = sc.nextInt();
        
        
        System.out.println("Enter name");
        s1 = sc.nextLine();
        
        System.out.println("Enter email");
        s2 = sc.nextLine();
        
        
        System.out.println("Enter password");
        s3 = sc.nextLine();
        
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `tptb` SET `tname`='"+s1+"',`temail`='"+s2+"',`tpass`='"+s3+"' WHERE tid = "+i1);
        
        preparedStatement.executeUpdate();
    }
    
    
    
    public  void delete () throws SQLException {
        Scanner sc = new Scanner(System.in);
        int i1;
        
        connection = DriverManager.getConnection("jdbc:mysql://localhost/tpdb","root","");
        
        System.out.println("Enter id");
        i1 = sc.nextInt();
        
        
        
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `tptb` WHERE tid = "+i1);
        
        preparedStatement.executeUpdate();
    }
    
    
    
    
    public  void display () throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        
        connection = DriverManager.getConnection("jdbc:mysql://localhost/tpdb","root","");
        
       
        PreparedStatement preparedStatement = connection.prepareStatement("select * from tptb");
        
        ResultSet resultSet =  preparedStatement.executeQuery();
        
        while(resultSet.next()){
            System.out.println("ID : "+resultSet.getInt("tid")+" Name : "+resultSet.getString("tname")+" Email : "+resultSet.getString("temail")+" Password : "+resultSet.getString("tpass"));
        }
        
    }
    
    
    
    
    public static void main(String[] args) throws SQLException {
        int opt;
        TpCrud obj = new TpCrud();
        Scanner sc = new Scanner(System.in);
        
        do{
            menu();
            opt = sc.nextInt();
            
            switch(opt){
                case 1:
                    obj.insert();
                    break;
                case 2:
                    obj.delete();
                    break;
                case 3:
                    obj.update();
                    break;
                case 4:
                    obj.display();
                    break;
            }
            
        }while(opt!=5);
        
    }
    
}
