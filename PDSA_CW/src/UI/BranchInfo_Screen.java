/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Data_Structures.BranchInfo_DS2;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author lewmi
 */
public class BranchInfo_Screen extends javax.swing.JFrame {

    /**
     * Creates new form BranchInfo_Screen
     */
    BranchInfo_DS2 bds2;
    
    public BranchInfo_Screen() {
        initComponents();
        bds2 = new BranchInfo_DS2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmb_Program = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_branchInfo = new javax.swing.JTable();
        btn_submit = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_branchName = new javax.swing.JTextField();
        txt_location = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_action = new javax.swing.JComboBox<>();
        lbl_nanoScnds = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cmb_Program.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cmb_Program.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select---", "Program 1", "Program 2", "Program 3", "Program 4" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Action");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Program");

        tbl_branchInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_branchInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Branch ID", "Branch Name", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_branchInfo.getTableHeader().setReorderingAllowed(false);
        tbl_branchInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_branchInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_branchInfo);

        btn_submit.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Branch Information");

        txt_branchName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txt_location.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Branch Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Location");

        cmb_action.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cmb_action.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select---", "Load", "Insert", "Update", "Delete" }));
        cmb_action.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_actionActionPerformed(evt);
            }
        });

        lbl_nanoScnds.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbl_nanoScnds.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Execution time in nano seconds :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addComponent(cmb_action, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_location, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_branchName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmb_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_nanoScnds, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
                        .addGap(55, 55, 55))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(cmb_action, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_branchName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_location, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_nanoScnds, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        long startTime = 00;
        long endTime = 00;
        if(cmb_action.getSelectedIndex() == 1)
        {
            if(cmb_Program.getSelectedIndex() == 3 || cmb_Program.getSelectedIndex() == 4)
            {
                startTime = System.nanoTime();
                bds2.Load(tbl_branchInfo);
                endTime = System.nanoTime();
                ClearFields();
            }
        }
        else if(cmb_action.getSelectedIndex() == 2)
        {
            if(!txt_branchName.getText().isEmpty() && !txt_location.getText().isEmpty() && (cmb_Program.getSelectedIndex() == 3 || cmb_Program.getSelectedIndex() == 4))
            {
                startTime = System.nanoTime();
                bds2.Add(txt_branchName.getText(), txt_location.getText(), tbl_branchInfo);
                endTime = System.nanoTime();
                ClearFields();
            }
        }
        else if(cmb_action.getSelectedIndex() == 3)
        {
            if(cmb_Program.getSelectedIndex() == 3 || cmb_Program.getSelectedIndex() == 4)
            {
                if(tbl_branchInfo.getRowCount() > 0 && tbl_branchInfo.getSelectedRowCount() > 0 && !txt_branchName.getText().isEmpty() && !txt_location.getText().isEmpty())
                {
                    startTime = System.nanoTime();
                    bds2.Update((String)tbl_branchInfo.getValueAt(tbl_branchInfo.getSelectedRow(), 0), txt_branchName.getText(), txt_location.getText(), tbl_branchInfo);
                    endTime = System.nanoTime();
                    ClearFields();
                }
            }
        }
        else if(cmb_action.getSelectedIndex() == 4)
        {
            if(cmb_Program.getSelectedIndex() == 3 || cmb_Program.getSelectedIndex() == 4)
            {
                if(tbl_branchInfo.getRowCount() > 0 && tbl_branchInfo.getSelectedRowCount() > 0)
                {
                    startTime = System.nanoTime();
                    bds2.Remove((String)tbl_branchInfo.getValueAt(tbl_branchInfo.getSelectedRow(), 0), tbl_branchInfo);
                    endTime = System.nanoTime();
                    ClearFields();
                }
            }
        }
        getExecTime(startTime,endTime);
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        ClearFields();
        lbl_nanoScnds.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tbl_branchInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_branchInfoMouseClicked
        // TODO add your handling code here:
        if(tbl_branchInfo.getSelectedRowCount() != 0)
        {
            if(cmb_action.getSelectedIndex() == 3 || cmb_action.getSelectedIndex() == 4)
            {
                txt_branchName.setText(tbl_branchInfo.getValueAt(tbl_branchInfo.getSelectedRow(), 1).toString());
                txt_location.setText(tbl_branchInfo.getValueAt(tbl_branchInfo.getSelectedRow(), 2).toString());
            }
        }
    }//GEN-LAST:event_tbl_branchInfoMouseClicked

    private void cmb_actionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_actionActionPerformed
        // TODO add your handling code here:
        ClearFields();
        lbl_nanoScnds.setText("");
    }//GEN-LAST:event_cmb_actionActionPerformed

    public void ClearFields()
    {
        txt_branchName.setText("");
        txt_location.setText("");
    }
    
    public void getExecTime(long startTime, long endTime)
    {
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.CEILING);
        long elapsedTime = endTime - startTime;
        Double inMiliSeconds = (double)elapsedTime/1000000000;
        lbl_nanoScnds.setText(String.valueOf(elapsedTime) + " ( " + df.format(inMiliSeconds) + "s ) ");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BranchInfo_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BranchInfo_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BranchInfo_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BranchInfo_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BranchInfo_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox<String> cmb_Program;
    private javax.swing.JComboBox<String> cmb_action;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_nanoScnds;
    private javax.swing.JTable tbl_branchInfo;
    private javax.swing.JTextField txt_branchName;
    private javax.swing.JTextField txt_location;
    // End of variables declaration//GEN-END:variables
}