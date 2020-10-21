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
    
    
    public int BranchInfoInsert(int branchId, String branchName, String branchLocation)
    {
        String insertSql = "INSERT INTO Branches VALUES ('"+branchId+"', '"+branchName+"', '"+branchLocation+"');";

        int count = 0;
        try 
        {
            PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            count = prepsInsertProduct.executeUpdate();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
    
    public int BranchInfoDelete(int branchId)
    {
        String deleteSql = "Delete from Branches where BranchId = '"+branchId+"';";

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
        String selectSql = "SELECT * from Branches";
        
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
    
    public int BranchInfoUpdate(int branchId, String branchName, String branchLocation)
    {
        String deleteSql = "Update Branches set BranchName = '"+branchName+"', Location = '"+branchLocation+"' where BranchId = '"+branchId+"';";
        
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

    public ResultSet BranchDistanceLoad()
    {
        String selectSql = "SELECT D.DistanceId, D.FromBranchId, FB.BranchName, FB.Location, D.ToBranchId, TB.BranchName, TB.Location, D.Distance from Distances D inner join Branches FB on D.FromBranchId = FB.BranchId inner join Branches TB on D.ToBranchId = TB.BranchId";
        
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
    
    public int BranchDistanceInsert(String[] arry)
    {
        String insertSql = "INSERT INTO Distances VALUES ('"+arry[0]+"', '"+arry[1]+"', '"+arry[4]+"', '"+arry[7]+"');";

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
    
    public int BranchDistanceInsert(int distanceId, int fromBranchId, int toBranchId, String distance)
    {
        String insertSql = "INSERT INTO Distances VALUES ('"+distanceId+"', '"+fromBranchId+"', '"+toBranchId+"', '"+distance+"');";

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
    
    public int BranchDistanceUpdate(String[] arry)
    {
        String deleteSql = "Update Distances set FromBranchId = '"+arry[1]+"', ToBranchId = '"+arry[4]+"', Distance = '"+arry[7]+"' where DistanceId = '"+arry[0]+"';";
        
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
    
     public int BranchDistanceUpdate(int distanceId, int fromBranchId, int toBranchId, String distance)
    {
        String deleteSql = "Update Distances set FromBranchId = '"+fromBranchId+"', ToBranchId = '"+toBranchId+"', Distance = '"+distance+"' where DistanceId = '"+distanceId+"';";
        
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
    
    public int BranchDistanceDelete(String id)
    {
        String deleteSql = "Delete from Distances where DistanceId = '"+id+"';";
      
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
    
    public int BranchDistanceDelete(int distanceId)
    {
        String deleteSql = "Delete from Distances where DistanceId = '"+distanceId+"';";
      
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