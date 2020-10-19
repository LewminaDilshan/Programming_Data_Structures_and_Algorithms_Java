/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Structures;

import DataBase_Access.DB_Access;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lewmi
 */
public class BranchDistance_DS2 {
    Queue<String[]> BranchInfoQueue;
    Queue<String[]> BranchDistanceQueue;
    DB_Access db;
    
    public BranchDistance_DS2()
    {
        BranchInfoQueue = new LinkedList<String[]>();
        BranchDistanceQueue = new LinkedList<String[]>();
        db = new DB_Access();
    }
    
    public void LoadBranchInfo(JTable jt)
    {
        ResultSet rs = db.BranchInfoLoad();
        BranchInfoQueue.clear();
        try{
            while(rs.next())
            {
                String[] aryRecd = new String[3];
                aryRecd[0] = String.valueOf(rs.getInt(1));
                aryRecd[1] = rs.getString(2);
                aryRecd[2] = rs.getString(3);
                BranchInfoQueue.add(aryRecd);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : BranchInfoQueue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
    
    public void Add(String fromId, String frombName, String frombLocation, String toId, String tobName, String tobLocation, String distance, JTable jt){
        int id = 0;
        if(jt.getRowCount() > 0)
        {
            id = Integer.parseInt((String) jt.getValueAt(jt.getModel().getRowCount()-1, 0));
        }
        String[] aryRecd = new String[8];
        aryRecd[0] = String.valueOf(id + 1);
        aryRecd[1] = fromId;
        aryRecd[2] = frombName;
        aryRecd[3] = frombLocation;
        aryRecd[4] = toId;
        aryRecd[5] = tobName;
        aryRecd[6] = tobLocation;
        aryRecd[7] = distance;
        
        int count = db.BranchDistanceInsert(aryRecd);
        if(count > 0)
            BranchDistanceQueue.add(aryRecd);
        
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : BranchDistanceQueue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
    
    public void Load(JTable jt){
        
        ResultSet rs = db.BranchDistanceLoad();
        BranchDistanceQueue.clear();
        try{
            while(rs.next())
            {
                String[] aryRecd = new String[8];
                aryRecd[0] = String.valueOf(rs.getInt(1));
                aryRecd[1] = rs.getString(2);
                aryRecd[2] = rs.getString(3);
                aryRecd[3] = rs.getString(4);
                aryRecd[4] = rs.getString(5);
                aryRecd[5] = rs.getString(6);
                aryRecd[6] = rs.getString(7);
                aryRecd[7] = rs.getString(8);
                BranchDistanceQueue.add(aryRecd);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : BranchDistanceQueue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
    
    public void Update(String id, String fromId, String frombName, String frombLocation, String toId, String tobName, String tobLocation, String distance, JTable jt){

        for (int i = 0; i < BranchDistanceQueue.size(); i++) {
            String[] selAry = BranchDistanceQueue.peek();
            if(selAry[0].equals(id))
            {
                String[] aryRecd = new String[8];
                aryRecd[0] = id;
                aryRecd[1] = fromId;
                aryRecd[2] = frombName;
                aryRecd[3] = frombLocation;
                aryRecd[4] = toId;
                aryRecd[5] = tobName;
                aryRecd[6] = tobLocation;
                aryRecd[7] = distance;
                
                int count = db.BranchDistanceUpdate(aryRecd);
                if(count > 0)
                {
                    BranchDistanceQueue.remove();
                    BranchDistanceQueue.add(aryRecd);
                }
                else
                    BranchDistanceQueue.add(BranchDistanceQueue.remove());    
            }
            else
            {
                BranchDistanceQueue.add(BranchDistanceQueue.remove());
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : BranchDistanceQueue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
    
    public void Remove(String id, JTable jt){

        for (int i = 0; i <= BranchDistanceQueue.size(); i++) {
            String[] selAry = BranchDistanceQueue.peek();
            if(selAry[0].equals(id))
            {
                int count = db.BranchDistanceDelete(id);
                if(count > 0)
                    BranchDistanceQueue.remove(); 
                else
                    BranchDistanceQueue.add(BranchDistanceQueue.remove());
            }
            else
            {
                BranchDistanceQueue.add(BranchDistanceQueue.remove());
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : BranchDistanceQueue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
}
