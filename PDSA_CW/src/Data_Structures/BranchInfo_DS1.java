/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Structures;
import DataBase_Access.DB_Access;
import Models.Branches;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author smprs
 */
public class BranchInfo_DS1 {
    
    Branches branch;
    LinkedList<Branches> linkedList;
    DB_Access db;
    
    public BranchInfo_DS1()
    {
        linkedList = new LinkedList<>();
        db = new DB_Access();
    }
    
    public void LoadBranchInformation(JTable branchInfo)
    {
        try
        {
            ResultSet rs = db.BranchInfoLoad();
            linkedList.clear();
            while(rs.next())
            {
                branch = new Branches();
                branch.setBranchId(rs.getInt(1));
                branch.setBranchName(rs.getString(2));
                branch.setLocation(rs.getString(3));
                linkedList.add(branch);
            }
        
            DefaultTableModel model = (DefaultTableModel) branchInfo.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for (Branches s : linkedList)
            {
                row[0] = s.getBranchId();
                row[1] = s.getBranchName();
                row[2] = s.getLocation();
                model.addRow(row);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void InsertBranchInformation(String branchName, String branchLocation, JTable branchInfo)
    {
        try
        {
            branch = new Branches();
            if(branchInfo.getRowCount() > 0)
            {
                branch.setBranchId(Integer.parseInt(String.valueOf(branchInfo.getValueAt(branchInfo.getModel().getRowCount()-1, 0)))+1);
            }
            else if(branchInfo.getRowCount() == 0)
            {
                branch.setBranchId(1);
            }
            branch.setBranchName(branchName);
            branch.setLocation(branchLocation); 
            int count = db.BranchInfoInsert(branch.getBranchId(),branch.getBranchName(),branch.getLocation());
            if(count > 0)
                linkedList.add(branch);
        
            DefaultTableModel model = (DefaultTableModel) branchInfo.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for (Branches s : linkedList)
            {
                row[0] = s.getBranchId();
                row[1] = s.getBranchName();
                row[2] = s.getLocation();
                model.addRow(row);
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
        
    public void UpdateBranchInformation(int branchId, String branchName, String branchLocation, JTable branchInfo)
    {

        try
        {
            for (int i = 0; i < linkedList.size(); i++) 
            {
                int Id = linkedList.peek().getBranchId();
                if(Id == branchId )
                {
                    branch = new Branches();
                    branch.setBranchId(branchId);
                    branch.setBranchName(branchName);
                    branch.setLocation(branchLocation);
                    int count = db.BranchInfoUpdate(branch.getBranchId(),branch.getBranchName(),branch.getLocation());
                    if(count>0)
                    {
                        linkedList.remove();
                        linkedList.add(branch);
                    }
                    else
                    {
                        linkedList.add(linkedList.remove());
                    }
                }
                else
                {
                    linkedList.add(linkedList.remove());
                }
            }
        
            DefaultTableModel model = (DefaultTableModel) branchInfo.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for (Branches s : linkedList)
            {
                row[0] = s.getBranchId();
                row[1] = s.getBranchName();
                row[2] = s.getLocation();
                model.addRow(row);
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public void DeleteBranchInformation(int branchId, JTable branchInfo)
    {
        try
        {
            branch = new Branches();
            branch.setBranchId(branchId);
            int count = db.BranchInfoDelete(branch.getBranchId());
            if(count>0)
            {
                Boolean result = linkedList.removeIf(Branches -> Branches.getBranchId() ==  branch.getBranchId());
            }
         
            DefaultTableModel model = (DefaultTableModel) branchInfo.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for (Branches s : linkedList)
            {
                row[0] = s.getBranchId();
                row[1] = s.getBranchName();
                row[2] = s.getLocation();
                model.addRow(row);
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
}
