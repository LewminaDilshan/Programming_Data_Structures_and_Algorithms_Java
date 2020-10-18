/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsa_cw;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lewmi
 */
public class BranchInfo_DS2 {
    
    Queue<String[]> Queue;
    DB_Access db;
    
    public BranchInfo_DS2() {
        Queue = new LinkedList<String[]>();
        db = new DB_Access();
    }
    
    public void Add(String bName, String bLocation, JTable jt){
        int id = 0;
        if(jt.getRowCount() > 0)
        {
            id = Integer.parseInt((String) jt.getValueAt(jt.getModel().getRowCount()-1, 0));
        }
        String[] aryRecd = new String[3];
        aryRecd[0] = String.valueOf(id + 1);
        aryRecd[1] = bName;
        aryRecd[2] = bLocation;
        
        db.BranchInfoInsert(aryRecd);

        Queue.add(aryRecd);
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : Queue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
    
    public void Remove(String id, JTable jt){

        for (int i = 0; i <= Queue.size(); i++) {
            String[] selAry = Queue.peek();
            if(selAry[0].equals(id))
            {
                Queue.remove();
                db.BranchInfoDelete(id);
            }
            else
            {
                Queue.add(Queue.remove());
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : Queue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
    
    public void Load(JTable jt){
        
        ResultSet rs = db.BranchInfoLoad();
        Queue.clear();
        try{
            while(rs.next())
            {
                String[] aryRecd = new String[3];
                aryRecd[0] = String.valueOf(rs.getInt(1));
                aryRecd[1] = rs.getString(2);
                aryRecd[2] = rs.getString(3);
                Queue.add(aryRecd);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : Queue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
    
    public void Update(String id, String bName, String bLocation, JTable jt){

        for (int i = 0; i < Queue.size(); i++) {
            String[] selAry = Queue.peek();
            if(selAry[0].equals(id))
            {
                Queue.remove();
                String[] aryRecd = new String[3];
                aryRecd[0] = id;
                aryRecd[1] = bName;
                aryRecd[2] = bLocation;
                Queue.add(aryRecd);
                db.BranchInfoUpdate(aryRecd);
            }
            else
            {
                Queue.add(Queue.remove());
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : Queue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
}
