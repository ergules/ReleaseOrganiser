/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hypesniper.ReleaseOrganizer;

import com.hypesniper.ReleaseOrganizer.auxilliary.AlertWorker;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class OrganizerGUI extends javax.swing.JFrame implements ActionListener {

    Timer timer;
    DataOperationsHandler operationHandler;

    /**
     * Creates new form OrganizerGUI
     */
    public OrganizerGUI() {
        initComponents();

        reshapeTabs();
        operationHandler = new DataOperationsHandler();
        reloadReleases();
        viewPanel1.setOperationHandler(operationHandler);
        editPanel1.setOperationHandler(operationHandler);
        historyPanel1.setOperationHandler(operationHandler);

        viewPanel1.populateTable();

        timer = new Timer(60 * 1000 - 50, this); // 50 ms precaution time
        timer.setInitialDelay(5000);
        timer.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        viewPanel1 = new com.hypesniper.ReleaseOrganizer.viewPanel();
        editPanel1 = new com.hypesniper.ReleaseOrganizer.editPanel();
        historyPanel1 = new com.hypesniper.ReleaseOrganizer.historyPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hypesniper.com  Release Organizer");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/media/favicon.png")));

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addTab(" View ", viewPanel1);
        jTabbedPane1.addTab(" Edit ", editPanel1);
        jTabbedPane1.addTab("History", historyPanel1);
        tablblHist = new javax.swing.JLabel("  History  ");
        tablblHist.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablblHist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/history.png")));
        tablblHist.setPreferredSize(new Dimension(86, 25));

        tablblEdit = new javax.swing.JLabel("  Edit    ");
        tablblEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablblEdit.setPreferredSize(new Dimension(86, 25));
        tablblEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/edit.png")));

        tablblView = new javax.swing.JLabel("  View    ");
        tablblView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablblView.setPreferredSize(new Dimension(86, 25));
        tablblView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/view.png")));
        jTabbedPane1.addTab(" Edit ", editPanel1);
        jTabbedPane1.addTab("History", historyPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        try {
            int selectedTab = jTabbedPane1.getSelectedIndex();
            if (selectedTab == 0) {
                viewPanel1.populateTable();
            } else if (selectedTab == 1) {
                editPanel1.populateTable();
            } else {
                historyPanel1.populateTable();
            }
        } catch (Exception e) {
            System.out.println("tabbedPane state change exception");
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrganizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrganizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrganizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrganizerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrganizerGUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hypesniper.ReleaseOrganizer.editPanel editPanel1;
    private com.hypesniper.ReleaseOrganizer.historyPanel historyPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.hypesniper.ReleaseOrganizer.viewPanel viewPanel1;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JLabel tablblHist;
    private javax.swing.JLabel tablblView;
    private javax.swing.JLabel tablblEdit;

    @Override
    public void actionPerformed(ActionEvent e) {
        new AlertWorker(operationHandler).execute();
        Calendar rightnow = Calendar.getInstance();
        int hour = rightnow.get(Calendar.HOUR_OF_DAY);
        int minute = rightnow.get(Calendar.MINUTE);
        if (hour == 0 && minute == 30) {
            reloadReleases();
        }
    }

    private void reshapeTabs() {
        jTabbedPane1.setTabComponentAt(0, tablblView);
        jTabbedPane1.setTabComponentAt(1, tablblEdit);
        jTabbedPane1.setTabComponentAt(2, tablblHist);
    }

    private void reloadReleases() {
        int expired = operationHandler.load();
        if (expired > 0) {
            String message = expired + " release(s) has expired."
                    + "You can view them on the History tab.";
            JOptionPane.showMessageDialog(viewPanel1, message);
        }
    }
}