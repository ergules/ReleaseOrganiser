/*
Pops up when user click settings on edit panel
Consists of three panels
1. set how many times before a release date notifications appear
2. replace releases with an external CSV file
3. export releases to a CSV file

 */
package com.hypesniper.ReleaseOrganizer.auxilliary;

import com.hypesniper.ReleaseOrganizer.DataOperationsHandler;
import com.hypesniper.ReleaseOrganizer.editPanel;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class settingsPopup extends javax.swing.JPanel {

    private DataOperationsHandler opHandler;
    private editPanel parentPanel;

    /**
     * Creates new form settingsPopup
     */
    public settingsPopup() {
        initComponents();
    }

    public void setOpHandler(DataOperationsHandler op) {
        this.opHandler = op;
    }

    public void setParent(editPanel ep) {
        this.parentPanel = ep;
    }

    public void setSpinner() {
        spinner.setValue(opHandler.getAlertBefore()); //To change body of generated methods, choose Tools | Templates.
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
        jLabel2 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        btnChoose = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spinner = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Import From File"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel2.setText("Drag or Choose a CSV file to import :");

        txtPath.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPath.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtPath.setMaximumSize(new java.awt.Dimension(0, 32));
        txtPath.setMinimumSize(new java.awt.Dimension(50, 25));

        btnChoose.setText("Choose");
        btnChoose.setMargin(new java.awt.Insets(0, 5, 0, 5));
        btnChoose.setMaximumSize(new java.awt.Dimension(0, 32));
        btnChoose.setMinimumSize(new java.awt.Dimension(50, 25));
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        btnImport.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImport)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnChoose, txtPath});

        txtPath.setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = (List<File>) evt
                    .getTransferable().getTransferData(
                        DataFlavor.javaFileListFlavor);
                    for (File file : droppedFiles) {
                        /*
                        * NOTE:
                        *  When I change this to a println,
                        *  it prints the correct path
                        */
                        txtPath.setText(file.getAbsolutePath());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Alert Before"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel1.setText("Set minutes before event for notification: ");

        spinner.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        spinner.setModel(new javax.swing.SpinnerNumberModel(555, 2, 999, 5));
        spinner.setPreferredSize(new java.awt.Dimension(56, 25));
        spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Export To File"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel3.setText("You can export releases to a CSV file");

        btnExport.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnExport.setText("Export");
        btnExport.setMaximumSize(new java.awt.Dimension(71, 25));
        btnExport.setMinimumSize(new java.awt.Dimension(71, 25));
        btnExport.setPreferredSize(new java.awt.Dimension(71, 25));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = (List<File>) evt
                    .getTransferable().getTransferData(
                        DataFlavor.javaFileListFlavor);
                    for (File file : droppedFiles) {
                        /*
                        * NOTE:
                        *  When I change this to a println,
                        *  it prints the correct path
                        */
                        txtPath.setText(file.getAbsolutePath());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerStateChanged
        // TODO add your handling code here:
        opHandler.setAlertBefore((Integer) spinner.getValue());
    }//GEN-LAST:event_spinnerStateChanged

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        // TODO add your handling code here:
        File fileName;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files Only", "csv");
        fileChooser.setFileFilter(filter);

        int dialogResult = fileChooser.showSaveDialog(fileChooser);
        if (dialogResult == JFileChooser.CANCEL_OPTION) {
            return;
        } else {
            fileName = fileChooser.getSelectedFile();
            System.out.println(fileName.getAbsoluteFile().toString());
        }
        txtPath.setText(fileName.getAbsoluteFile().toString());
    }//GEN-LAST:event_btnChooseActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:

        File impFile = new File(txtPath.getText().trim());
        if (!impFile.exists() || !impFile.toString().toLowerCase().endsWith(".csv")) {
            JOptionPane.showMessageDialog(this, "Please select a valid .CSV file");
            return;
        }

        int dialogResult = JOptionPane.showConfirmDialog(this,
                "You are about to replace ALL items. Are you sure to proceed? \n"
                + "Your old CSV file be moved under the dump directory.\n",
                "Confirm Import", JOptionPane.OK_CANCEL_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            opHandler.dump();
            int expired = opHandler.load(impFile);

            if (expired > 0) {
                String message = "Beware " + expired + " release(s) in the file was expired."
                        + "You can view them on the History tab.";
                JOptionPane.showMessageDialog(this, message);
            }
            parentPanel.populateTable();
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        File fileName = new File(System.getProperty("user.home") + "/Desktop/Releases.csv");
        JFileChooser fileSave = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files Only", "csv");
        fileSave.setFileFilter(filter);

        fileSave.setSelectedFile(fileName);  // Default file save edstination is set to Desktop
        // ASks user where to save file
        int dialogResult = fileSave.showSaveDialog(fileSave);
        if (dialogResult == JFileChooser.CANCEL_OPTION) {
            return; // User cancelled save operation
        } else {
            fileName = fileSave.getSelectedFile();
            String message;
            if(opHandler.save(fileName)) message = "File saved succesfully \n\n";
            else message = "An error occured while saving file, please try again.\n\n";
            JOptionPane.showMessageDialog(parentPanel, message, "Export to File", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables

}
