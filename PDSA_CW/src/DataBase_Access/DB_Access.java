/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase_Access;

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
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int BranchInfoInsert(String[] arry)
    {
        String insertSql = "INSERT INTO Branches VALUES ('"+arry[0]+"', '"+arry[1]+"', '"+arry[2]+"');";

        int count = 0;
        try 
        {
            PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            count = prepsInsertProduct.executeUpdate();
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;
    }
    
    public int BranchInfoDelete(String id)
    {
        String deleteSql = "Delete from Branches where BranchId = '"+id+"';";

        int count = 0;
        try 
        {
            PreparedStatement prepsInsertProduct = connection.prepareStatement(deleteSql, Statement.RETURN_GENERATED_KEYS);
            count = prepsInsertProduct.executeUpdate();
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;
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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return resultSet;
    }
    
    public int BranchInfoUpdate(String[] arry)
    {
        String deleteSql = "Update Branches set BranchName = '"+arry[1]+"', Location = '"+arry[2]+"' where BranchId = '"+arry[0]+"';";
        
        int count = 0;
        try 
        {
            PreparedStatement prepsInsertProduct = connection.prepareStatement(deleteSql, Statement.RETURN_GENERATED_KEYS);
            count = prepsInsertProduct.executeUpdate();
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;
    }
}