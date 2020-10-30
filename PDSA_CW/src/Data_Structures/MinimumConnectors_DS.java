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
 * @author smprs
 */
public class MinimumConnectors_DS {
    
    Queue<String[]> BranchDistanceQueue;
    DB_Access db;
    int MaxBranchId = 0;
    Graph graph;
    
    public MinimumConnectors_DS()
    {
        BranchDistanceQueue = new LinkedList<String[]>();
        db = new DB_Access();
    }
    
    public void LoadBranchDistances(JTable jt)
    {        
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
}
