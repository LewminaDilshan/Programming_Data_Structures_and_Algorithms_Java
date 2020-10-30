/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Structures;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lewmi
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BranchInfo_DS2Test {
    
    public BranchInfo_DS2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    /**
     * Test of Load method, of class BranchInfo_DS2.
     */
    @Test
    public void test1Load() {
        System.out.println("Load");
        
        JTable jt = new JTable();
        String[] header = {"Branch ID","Branch Name","Location"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        jt.setModel(model);
        
        BranchInfo_DS2 instance = new BranchInfo_DS2();
        instance.Load(jt);
        
        DefaultTableModel modeltest = (DefaultTableModel) jt.getModel();

        assertEquals(model.getRowCount() > 0, modeltest.getRowCount() > 0);
    }

    /**
     * Test of Add method, of class BranchInfo_DS2.
     */
    @Test
    public void test2Add() {
        System.out.println("Add");
        String bName = "ABC";
        String bLocation = "XYZ";
        
        JTable jt = new JTable();
        String[] header = {"Branch ID","Branch Name","Location"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        jt.setModel(model);
        
        BranchInfo_DS2 instance = new BranchInfo_DS2();
        instance.Load(jt);
        
        int initialRowCount = jt.getRowCount();
        int expectRowCount = initialRowCount + 1;
        
        instance.Add(bName, bLocation, jt);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expectRowCount > initialRowCount, jt.getRowCount() > initialRowCount);
    }

    /**
     * Test of Remove method, of class BranchInfo_DS2.
     */
    @Test
    public void test4Remove() {
        System.out.println("Remove");
        String id = "6";
        
        JTable jt = new JTable();
        String[] header = {"Branch ID","Branch Name","Location"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        jt.setModel(model);
        
        BranchInfo_DS2 instance = new BranchInfo_DS2();
        instance.Load(jt);
        
        int initialRowCount = jt.getRowCount();
        int expectRowCount = initialRowCount - 1;

        instance.Remove(id, jt);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expectRowCount < initialRowCount, jt.getRowCount() < initialRowCount);
    }

    /**
     * Test of Update method, of class BranchInfo_DS2.
     */
    @Test
    public void test3Update() {
        System.out.println("Update");
        String id = "4";
        String bName = "Kiribathgoda Branch";
        String bLocation = "Kiribathgoda";
        
        String expectBranchName = "Kiribathgoda Branch";
        
        JTable jt = new JTable();
        String[] header = {"Branch ID","Branch Name","Location"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        jt.setModel(model);
        
        BranchInfo_DS2 instance = new BranchInfo_DS2();
        instance.Load(jt);        

        instance.Update(id, bName, bLocation, jt);
        
        for (int row = 0; row < jt.getRowCount(); row++){
            if(jt.getValueAt(row, 0).toString() == id)
            {
                assertEquals(expectBranchName == bName, jt.getValueAt(row, 1).toString() == bName);
                break;
            }
        }
    }
    
}
