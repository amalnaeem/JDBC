/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amal
 */
public class JDBC {

    /**
     * @param args the command line arguments
     */
    
    public static void statementClass(Connection conn){
    
        try {
            conn.setAutoCommit(false);
            Statement st = conn.createStatement();
            String _deleteTableData ="TRUNCATE TABLE STUDENT";
        st.executeUpdate(_deleteTableData);
            for(int i = 1 ; i <= 5000;i++)
            {
               int reg = i;
               String name = "amal"+i;
               int semester = 6;
               String address = "nust";
            int rs=st.executeUpdate("INSERT INTO STUDENT values('"+name+"','"+reg+"','"+semester+"','"+address+"')");
            conn.commit();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public static void statementClassAuto(Connection conn){
    
        try {
            conn.setAutoCommit(true);
            Statement st = conn.createStatement();
            String _deleteTableData ="TRUNCATE TABLE STUDENT";
        st.executeUpdate(_deleteTableData);
            for(int i = 1 ; i <= 5000;i++)
            {
               int reg = i;
               String name = "amal"+i;
               int semester = 6;
               String address = "nust";
            int rs=st.executeUpdate("INSERT INTO STUDENT values('"+name+"','"+reg+"','"+semester+"','"+address+"')");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    public static void preparedStatement(Connection conn)
    {
    
     try {
         conn.setAutoCommit(false);   
         Statement st = conn.createStatement();
            String _deleteTableData ="TRUNCATE TABLE STUDENT";
        st.executeUpdate(_deleteTableData);
            for(int i = 1 ; i <= 5000;i++)
            {
               int reg = i;
               String name = "amal"+i;
               int semester = 6;
               String address = "nust";
               String query = " insert into student values (?, ?, ?, ?)";

                                  // create the mysql insert preparedstatement
                                  PreparedStatement preparedStmt = conn.prepareStatement(query);
                                  preparedStmt.setString (1, name);
                                  preparedStmt.setInt(2, reg);
                                  preparedStmt.setInt (3, semester);
                                  preparedStmt.setString (4, address);
                 preparedStmt.executeUpdate();
                 conn.commit();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    public static void preparedStatementAuto(Connection conn)
    {
    
     try {
         conn.setAutoCommit(true);   
         Statement st = conn.createStatement();
            String _deleteTableData ="TRUNCATE TABLE STUDENT";
        st.executeUpdate(_deleteTableData);
            for(int i = 1 ; i <= 5000;i++)
            {
               int reg = i;
               String name = "amal"+i;
               int semester = 6;
               String address = "nust";
               String query = " insert into student values (?, ?, ?, ?)";

                                  // create the mysql insert preparedstatement
                                  PreparedStatement preparedStmt = conn.prepareStatement(query);
                                  preparedStmt.setString (1, name);
                                  preparedStmt.setInt(2, reg);
                                  preparedStmt.setInt (3, semester);
                                  preparedStmt.setString (4, address);
                 preparedStmt.executeUpdate();
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public static void batchUpdate(Connection conn)
    {
    
    try {
        
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();
        String _deleteTableData ="TRUNCATE TABLE STUDENT";
        st.executeUpdate(_deleteTableData);
         String query = " insert into student values (?, ?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
            for(int i = 1 ; i <= 5000;i++)
            {
               int reg = i;
               String name = "amal"+i;
               int semester = 6;
               String address = "nust";
              

                                  // create the mysql insert preparedstatement
                                  
                                  preparedStmt.setString (1, name);
                                  preparedStmt.setInt(2, reg);
                                  preparedStmt.setInt (3, semester);
                                  preparedStmt.setString (4, address);
                 preparedStmt.addBatch();
                 conn.commit();
            }
            
        int[] executeBatch = preparedStmt.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
     public static void batchUpdateAuto(Connection conn)
    {
    
    try {
        
        conn.setAutoCommit(true);
        Statement st = conn.createStatement();
        String _deleteTableData ="TRUNCATE TABLE STUDENT";
        st.executeUpdate(_deleteTableData);
         String query = " insert into student values (?, ?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
            for(int i = 1 ; i <= 5000;i++)
            {
               int reg = i;
               String name = "amal"+i;
               int semester = 6;
               String address = "nust";
              

                                  // create the mysql insert preparedstatement
                                  
                                  preparedStmt.setString (1, name);
                                  preparedStmt.setInt(2, reg);
                                  preparedStmt.setInt (3, semester);
                                  preparedStmt.setString (4, address);
                 preparedStmt.addBatch();
            }
            
        int[] executeBatch = preparedStmt.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
     public static void storedProcedure(Connection conn)
    {
    
    try {
        
        conn.setAutoCommit(true);
        Statement st = conn.createStatement();
        String _deleteTableData ="TRUNCATE TABLE STUDENT";
        st.executeUpdate(_deleteTableData);
        Statement st1 = conn.createStatement();
        
       

  
        
        String query = "{CALL records(?,?,?,?)}";
        CallableStatement stmt = conn.prepareCall(query);
        
         //String query = " insert into student values (?, ?, ?, ?)";
        //PreparedStatement preparedStmt = conn.prepareStatement(query);
            for(int i = 1 ; i <= 5000;i++)
            {
               int reg = i;
               String name = "amal"+i;
               int semester = 6;
               String address = "nust";
              

                                  // create the mysql insert preparedstatement
                                  
                                  stmt.setString (1, name);
                                  stmt.setInt(2, reg);
                                  stmt.setInt (3, semester);
                                  stmt.setString (4, address);
                                  stmt.executeQuery();
            }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
     
     
     public static void storedProcedureAuto(Connection conn)
    {
    
   
        
         try {
        
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();
        String _deleteTableData ="TRUNCATE TABLE STUDENT";
        st.executeUpdate(_deleteTableData);
        Statement st1 = conn.createStatement();
        
       

  
        
        String query = "{CALL records(?,?,?,?)}";
        CallableStatement stmt = conn.prepareCall(query);
        
         //String query = " insert into student values (?, ?, ?, ?)";
        //PreparedStatement preparedStmt = conn.prepareStatement(query);
            for(int i = 1 ; i <= 5000;i++)
            {
               int reg = i;
               String name = "amal"+i;
               int semester = 6;
               String address = "nust";
              

                                  // create the mysql insert preparedstatement
                                  
                                  stmt.setString (1, name);
                                  stmt.setInt(2, reg);
                                  stmt.setInt (3, semester);
                                  stmt.setString (4, address);
                                  stmt.executeQuery();
            }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
     
     
    public static void main(String[] args) {
       
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost/students?useSSL=true";

        //  Database credentials
        final String USER = "root";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/students?useSSL=true", "root","");
            
            
            long startTime1 = System.currentTimeMillis();
            JDBC.statementClass(conn);
            long endTime1 = System.currentTimeMillis();
            
            long time1 =  endTime1-startTime1;
            
            
            long startTime2 = System.currentTimeMillis();
            JDBC.preparedStatement(conn);
            long endTime2 = System.currentTimeMillis();
            
            long time2 =  endTime2-startTime2;
            
            
            long startTime3 = System.currentTimeMillis();
            JDBC.batchUpdate(conn);
            long endTime3 = System.currentTimeMillis();
            
            long time3 =  endTime3-startTime3;
            
             long startTime4 = System.currentTimeMillis();
            JDBC.statementClassAuto(conn);
            long endTime4 = System.currentTimeMillis();
            
            long time4 =  endTime4-startTime4;
            
             long startTime5 = System.currentTimeMillis();
            JDBC.preparedStatementAuto(conn);
            long endTime5 = System.currentTimeMillis();
            
            long time5 =  endTime5-startTime5;
            
            
             long startTime6 = System.currentTimeMillis();
            JDBC.batchUpdateAuto(conn);
            long endTime6 = System.currentTimeMillis();
            
            long time6 =  endTime6-startTime6;
            
            long startTime7 = System.currentTimeMillis();
            JDBC.storedProcedure(conn);
            long endTime7 = System.currentTimeMillis();
            
            long time7 =  endTime7-startTime7;
            
             long startTime8 = System.currentTimeMillis();
            JDBC.storedProcedure(conn);
            long endTime8 = System.currentTimeMillis();
            
            long time8 =  endTime8-startTime8;
            
            System.out.println("Time taken by  Statement Class with AutoCommit(false) is: "+ time1 + " ms");
            
            System.out.println("Time taken by  Statement Class with AutoCommit(true) is: "+ time4 + " ms");
            
            System.out.println("Time taken by Prepared Statement with AutoCommit(false) is: "+ time2 + " ms");
            
            System.out.println("Time taken by Prepared Statement with AutoCommit(true) is: "+ time5 + " ms");
            
            System.out.println("Time taken by Batch Statement with AutoCommit(false) is: "+ time3 + " ms");
            
            System.out.println("Time taken by Batch Statement with AutoCommit(true) is: "+ time6 + " ms");
            
            System.out.println("Time taken by Stored Procedures with AutoCommit(false) is: "+ time7 + " ms");
            
            System.out.println("Time taken by Stored Procedures with AutoCommit(true) is: "+ time8 + " ms");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
	
        
        
    }
    
}
