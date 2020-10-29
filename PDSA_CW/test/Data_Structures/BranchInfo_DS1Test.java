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
 * @author smprs
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BranchInfo_DS1Test {
    
    static DefaultTableModel tbl_branchInfo; 
    static JTable branchInfo;
    BranchInfo_DS1 instance ;
    public BranchInfo_DS1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         String[][] data = { }; 
  
        // Column Names 
        String[] columnNames = { "Branch ID", "Branch Name", "Location" }; 
  
        // Initializing the JTable 
        tbl_branchInfo = new DefaultTableModel(data, columnNames); 
        branchInfo = new JTable(tbl_branchInfo);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {      
        instance = new BranchInfo_DS1();
    }
    
    @After
    public void tearDown() {
      
    }

    /**
     * Test of LoadBranchInformation method, of class BranchInfo_DS1.
     */
    @Test
    public void test1LoadBranchInformation() {
        System.out.println("\n\nLoadBranchInformation");
        instance.LoadBranchInformation(branchInfo);
//        for (int row = 0; row < branchInfo.getRowCount(); row++)
//        {
//            for (int column = 0; column < branchInfo.getColumnCount(); column++)
//            {
//                System.out.println(branchInfo.getValueAt(row, column).toString());
//            }
//        }
        DefaultTableModel modeltest = (DefaultTableModel) branchInfo.getModel();
        assertEquals(tbl_branchInfo.getRowCount() > 0, modeltest.getRowCount() > 0);
    }

    /**
     * Test of InsertBranchInformation method, of class BranchInfo_DS1.
     */
    @Test
    public void test2InsertBranchInformation() {
        instance.LoadBranchInformation(branchInfo);
        int initialRowCount = branchInfo.getRowCount();
        int expectRowCount = initialRowCount + 1;
        System.out.println("\n\nInsertBranchInformation");
        String branchName = "Kollupitiya Super Branch";
        String branchLocation = "Kollupitiya"; 
        instance.InsertBranchInformation(branchName, branchLocation, branchInfo);
//        for (int row = 0; row < branchInfo.getRowCount(); row++)
//        {
//            for (int column = 0; column < branchInfo.getColumnCount(); column++)
//            {
//                System.out.println(branchInfo.getValueAt(row, column).toString());
//            }
//        }
        assertEquals(expectRowCount > initialRowCount, branchInfo.getRowCount() > initialRowCount);
    }

    /**
     * Test of UpdateBranchInformation method, of class BranchInfo_DS1.
     */
    @Test
    public void test3UpdateBranchInformation() {
        System.out.println("\n\nUpdateBranchInformation");
        int branchId = 6;
        String branchName = "Kollupitaya Super Branch";
        String branchLocation = "Colombo 03";
        String expectBranchLocation = "Colombo 03";
        instance.LoadBranchInformation(branchInfo);
        instance.UpdateBranchInformation(branchId, branchName, branchLocation, branchInfo);
//        for (int row = 0; row < branchInfo.getRowCount(); row++)
//        {
//            for (int column = 0; column < branchInfo.getColumnCount(); column++)
//            {
//            System.out.println(branchInfo.getValueAt(row, column).toString());
//            }
//        }
          for (int row = 0; row < branchInfo.getRowCount(); row++){
            if(String.valueOf(branchId).equals(branchInfo.getValueAt(row, 1).toString()))
            {
                assertEquals(expectBranchLocation.equals(branchLocation), branchInfo.getValueAt(row, 1).toString().equals(branchLocation));
                break;
            }
          }
    }

    /**
     * Test of DeleteBranchInformation method, of class BranchInfo_DS1.
     */
    @Test
    public void test4DeleteBranchInformation() {
        instance.LoadBranchInformation(branchInfo);
        int initialRowCount = branchInfo.getRowCount();
        int expectRowCount = initialRowCount - 1;
        System.out.println("\n\nDeleteBranchInformation");
        int branchId = 6;
        instance.LoadBranchInformation(branchInfo);
        instance.DeleteBranchInformation(branchId, branchInfo);
//        for (int row = 0; row < branchInfo.getRowCount(); row++)
//        {
//            for (int column = 0; column < branchInfo.getColumnCount(); column++)
//            {
//            System.out.println(branchInfo.getValueAt(row, column).toString());
//            }
//        }
        assertEquals(expectRowCount < initialRowCount, branchInfo.getRowCount() < initialRowCount);
    } 
}
