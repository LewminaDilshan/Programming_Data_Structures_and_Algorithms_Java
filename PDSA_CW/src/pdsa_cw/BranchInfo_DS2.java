/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsa_cw;

import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lewmi
 */
public class BranchInfo_DS2 {
    
    Queue<String[]> Queue;
    
    public BranchInfo_DS2() {
        Queue = new LinkedList<String[]>();
    }
    
    public void Insert(String bName, String bLocation, JTable jt){
        int id = 0;
        if(jt.getRowCount() > 0)
        {
            id = Integer.parseInt((String) jt.getValueAt(jt.getModel().getRowCount()-1, 0));
        }
        String[] aryRecd = new String[3];
        aryRecd[0] = String.valueOf(id + 1);
        aryRecd[1] = bName;
        aryRecd[2] = bLocation;

        Queue.add(aryRecd);
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        for(String[] s : Queue) { 
            Object[] row = s;
            model.addRow(row);
        }
    }
}
