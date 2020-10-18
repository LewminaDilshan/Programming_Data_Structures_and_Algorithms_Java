/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsa_cw;

/**
 *
 * @author lewmi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Access {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    Connection connection;

    public DB_Access()
    {       
        String url = "jdbc:sqlserver://MSI\\SQLFULL:1433;databaseName=PDSACourseWork;";
        String user = "sa";
        String pass = "12345";

        try  {
            connection = DriverManager.getConnection(url,user, pass);
            // Code here.
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void BranchInfoInsert(String[] arry)
    {
        String insertSql = "INSERT INTO Branches VALUES ('"+arry[0]+"', '"+arry[1]+"', '"+arry[2]+"');";
        
        ResultSet resultSet = null;

        try 
        {
            PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void BranchInfoDelete(String id)
    {
        String deleteSql = "Delete from Branches where BranchId = '"+id+"';";
        
        ResultSet resultSet = null;

        try 
        {
            PreparedStatement prepsInsertProduct = connection.prepareStatement(deleteSql, Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet BranchInfoLoad()
    {
        String selectSql = "SELECT TOP 10 BranchId, BranchName, Location from Branches";
        
        ResultSet resultSet = null;

        try 
        {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(selectSql);
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultSet;
    }
    
    public void BranchInfoUpdate(String[] arry)
    {
        String deleteSql = "Update Branches set BranchName = '"+arry[1]+"', Location = '"+arry[2]+"' where BranchId = '"+arry[0]+"';";
        
        ResultSet resultSet = null;

        try 
        {
            PreparedStatement prepsInsertProduct = connection.prepareStatement(deleteSql, Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}