/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Structures;
import DataBase_Access.DB_Access;
import Models.*;
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
public class BranchDistance_DS1 {
    
    DB_Access db;
    
    Distances distances;
    LinkedList<Distances> linkedListDistances;
    Branches branches;
    LinkedList<Branches> linkedListBranches;
    
    public BranchDistance_DS1()
    {
        linkedListDistances = new LinkedList<>();
        linkedListBranches = new LinkedList<>();
        db = new DB_Access();
    }
    
    public void LoadBranchInfomation(JTable branchInfo)
    {
        try
        {
            ResultSet rs = db.BranchInfoLoad();
            linkedListBranches.clear();
            while(rs.next())
            {
                branches = new Branches();
                branches.setBranchId(rs.getInt(1));
                branches.setBranchName(rs.getString(2));
                branches.setLocation(rs.getString(3));
                linkedListBranches.add(branches);
            }
        
//            DefaultTableModel model = (DefaultTableModel) branchInfo.getModel();
//            model.setRowCount(0);
//            Object[] row = new Object[3];
//            for (Branches s : linkedListBranches)
//            {
//                row[0] = s.getBranchId();
//                row[1] = s.getBranchName();
//                row[2] = s.getLocation();
//                model.addRow(row);
//            }
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
    
    public void LoadDistanceInformation(JTable distanceInfo)
    {
        
        ResultSet rs = db.BranchDistanceLoad();
        linkedListDistances.clear();
        try
        {
            while(rs.next())
            {
                distances = new Distances();
                distances.setDistanceId(rs.getInt(1));
                distances.setFromBranchId(rs.getInt(5));
                distances.setToBranchId(rs.getInt(1));
                distances.setDistance(rs.getString(8));
                linkedListDistances.add(distances);
            }
      
            DefaultTableModel model = (DefaultTableModel) distanceInfo.getModel();
            model.setRowCount(0);
            Object[] row = new Object[8];
            for (Distances d : linkedListDistances)
            {
                row[0] = d.getDistanceId();
                linkedListBranches.forEach((b) -> {
                    if(b.getBranchId()== d.getFromBranchId())
                    {
                        row[1] = b.getBranchId();
                        row[2] = b.getBranchName();
                        row[3] = b.getLocation();
                    }
                    else if(b.getBranchId()== d.getFromBranchId())
                    {
                        row[4] = b.getBranchId();
                        row[5] = b.getBranchName();
                        row[6] = b.getLocation();
                    }
                });
                row[7] = d.getDistance();
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
    
    public void InsertDistanceInformation(int fromBranchId, int toBranchId, String distance, JTable distanceInfo)
    {
        try
        {
            distances = new Distances();
            if(distanceInfo.getRowCount() > 0)
            {
                distances.setDistanceId(Integer.parseInt(String.valueOf(distanceInfo.getValueAt(distanceInfo.getModel().getRowCount()-1, 0)))+1);
            }
            else if(distanceInfo.getRowCount() == 0)
            {
                distances.setDistanceId(0);
            }
            distances.setFromBranchId(fromBranchId);
            distances.setToBranchId(toBranchId); 
            distances.setDistance(distance);
            int count = db.BranchDistanceInsert(distances.getDistanceId(),distances.getFromBranchId(),distances.getToBranchId(),distances.getDistance());
            if(count > 0)
                linkedListDistances.add(distances);
        
           
            DefaultTableModel model = (DefaultTableModel) distanceInfo.getModel();
            model.setRowCount(0);
            Object[] row = new Object[8];
            for (Distances d : linkedListDistances)
            {
                row[0] = d.getDistanceId();
                linkedListBranches.forEach((b) -> {
                    if(b.getBranchId()== d.getFromBranchId())
                    {
                        row[1] = b.getBranchId();
                        row[2] = b.getBranchName();
                        row[3] = b.getLocation();
                    }
                    else if(b.getBranchId()== d.getFromBranchId())
                    {
                        row[4] = b.getBranchId();
                        row[5] = b.getBranchName();
                        row[6] = b.getLocation();
                    }
                });
                row[7] = d.getDistance();
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
    
    public void UpdateDistanceInformation(int distanceId, int fromBranchId, int toBranchId, String distance, JTable distanceInfo)
    {

        try
        {
            for (int i = 0; i < linkedListDistances.size(); i++) 
            {
                int Id = linkedListDistances.peek().getDistanceId();
                if(Id == distanceId )
                {
                    distances = new Distances();
                    distances.setDistanceId(distanceId);
                    distances.setFromBranchId(fromBranchId);
                    distances.setToBranchId(toBranchId); 
                    distances.setDistance(distance);
                    int count = db.BranchDistanceUpdate(distances.getDistanceId(),distances.getFromBranchId(),distances.getToBranchId(),distances.getDistance());
                    if(count>0)
                    {
                        linkedListDistances.remove();
                        linkedListDistances.add(distances);
                    }
                    else
                    {
                        linkedListDistances.add(linkedListDistances.remove());
                    }
                }
                else
                {
                    linkedListDistances.add(linkedListDistances.remove());
                }
            }
        
            DefaultTableModel model = (DefaultTableModel) distanceInfo.getModel();
            model.setRowCount(0);
            Object[] row = new Object[8];
            for (Distances d : linkedListDistances)
            {
                row[0] = d.getDistanceId();
                linkedListBranches.forEach((b) -> {
                    if(b.getBranchId()== d.getFromBranchId())
                    {
                        row[1] = b.getBranchId();
                        row[2] = b.getBranchName();
                        row[3] = b.getLocation();
                    }
                    else if(b.getBranchId()== d.getFromBranchId())
                    {
                        row[4] = b.getBranchId();
                        row[5] = b.getBranchName();
                        row[6] = b.getLocation();
                    }
                });
                row[7] = d.getDistance();
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
        
    public void DeleteDistanceInformation(int distanceId, JTable distanceInfo)
    {
        try
        {
            distances = new Distances();
            distances.setDistanceId(distanceId);
            int count = db.BranchDistanceDelete(distances.getDistanceId());
            if(count>0)
            {
                Boolean result = linkedListDistances.removeIf(Distances -> Distances.getDistanceId() ==  distances.getDistanceId());
            }
         
            DefaultTableModel model = (DefaultTableModel) distanceInfo.getModel();
            model.setRowCount(0);
            Object[] row = new Object[8];
            for (Distances d : linkedListDistances)
            {
                row[0] = d.getDistanceId();
                linkedListBranches.forEach((b) -> {
                    if(b.getBranchId()== d.getFromBranchId())
                    {
                        row[1] = b.getBranchId();
                        row[2] = b.getBranchName();
                        row[3] = b.getLocation();
                    }
                    else if(b.getBranchId()== d.getFromBranchId())
                    {
                        row[4] = b.getBranchId();
                        row[5] = b.getBranchName();
                        row[6] = b.getLocation();
                    }
                });
                row[7] = d.getDistance();
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
