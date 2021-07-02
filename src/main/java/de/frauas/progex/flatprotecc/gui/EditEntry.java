/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.de.frauas.progex.flatprotecc.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import main.java.de.frauas.progex.flatprotecc.Connect2DB;
import main.java.de.frauas.progex.flatprotecc.EncryptorDecryptor;

/**
 *
 * @author ana
 */
public class EditEntry extends javax.swing.JFrame {
    
    private final int userId;
    private final int entryId;
    /**
     * Creates new form EditEntry
     */
    public EditEntry(int userId, int entryId) {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        this.userId = userId;
        this.entryId = entryId;
        
        EncryptorDecryptor decryptor = new EncryptorDecryptor();
        Connect2DB connCreator = new Connect2DB();
        Connection conn = connCreator.StartConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM entry WHERE acc_id=" + userId + " AND id=" + entryId + ";");
            rs.next();
            jTextFieldTitle.setText(rs.getString("title"));
            jTextUsername.setText(rs.getString("username"));
            jTextEmail.setText(rs.getString("mail"));
            jTextComment.setText(rs.getString("com"));
            String cipher = rs.getString("pwd");
            jTextFieldPw.setText(decryptor.decryptString(cipher));
            jTextFieldPwConf.setText(decryptor.decryptString(cipher));
            passwordBar1.setSecurityLevel(jTextFieldPw.getText());
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCancel = new javax.swing.JButton();
        jLabelEditEntry = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldTitle = new javax.swing.JTextField();
        jLabelTitle = new javax.swing.JLabel();
        jTextUsername = new javax.swing.JTextField();
        jLabelUsername = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelConfirmLabel = new javax.swing.JLabel();
        jTextComment = new javax.swing.JTextField();
        jLabelComment = new javax.swing.JLabel();
        jTextFieldPwConf = new javax.swing.JTextField();
        jTextFieldPw = new javax.swing.JTextField();
        passwordBar1 = new main.java.de.frauas.progex.flatprotecc.PasswordBar();
        jButtonConfirm = new javax.swing.JButton();
        jButtonCancel1 = new javax.swing.JButton();

        jButtonCancel.setText("Cancel");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));

        jLabelEditEntry.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEditEntry.setText("Edit Entry");

        jLabelTitle.setText("Website/Application");

        jLabelUsername.setText("Username");

        jLabelEmail.setText("E-Mail");

        jLabelPassword.setText("Password");

        jLabelConfirmLabel.setText("Confirm Password");

        jLabelComment.setText("Comment");

        jTextFieldPw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPwKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelComment, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextComment))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextUsername))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPw))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelConfirmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPwConf)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jTextFieldPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConfirmLabel)
                    .addComponent(jTextFieldPwConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextComment, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jLabelComment))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonConfirm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonConfirm.setText("Confirm");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });

        jButtonCancel1.setBackground(new java.awt.Color(255, 51, 0));
        jButtonCancel1.setText("Cancel");
        jButtonCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabelEditEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEditEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConfirm)
                        .addGap(34, 34, 34))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancel1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancel1ActionPerformed

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        Connect2DB connCreator = new Connect2DB();
        Connection conn = connCreator.StartConnection();
        if (conn != null) {
            System.out.println("####EDIT NEW ENTRY#####");
            System.out.println("#connection successful#");
            System.out.println("#######################");
        }

        String password = String.valueOf(jTextFieldPw.getText());
        String passwordConfirm = String.valueOf(jTextFieldPwConf.getText());

        if (!password.equals(passwordConfirm)) {
            JOptionPane.showMessageDialog(null, "Password does not match with confirmed password!", "Password Check", JOptionPane.ERROR_MESSAGE);
        } else if (jTextEmail.getText().equals("") && jTextUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a username or Email", "Incomplete data", JOptionPane.ERROR_MESSAGE);
        } else if (jTextFieldTitle.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a platform or service name", "Incomplete data", JOptionPane.ERROR_MESSAGE);
        } else if (jTextFieldTitle.getText().length() >= 100) {
            JOptionPane.showMessageDialog(null, "Please enter a platform or service name, that has less than 100 characters", "Incomplete data", JOptionPane.ERROR_MESSAGE);
        } else if (jTextComment.getText().length() >= 400) {
            JOptionPane.showMessageDialog(null, "Comment cannot be longer than 400 characters", "Incomplete data", JOptionPane.ERROR_MESSAGE);
        }else {
            try {
                Statement stm = conn.createStatement();
                EncryptorDecryptor ed = new EncryptorDecryptor();
                
                String sql = "UPDATE entry SET "
                        + "title='" + jTextFieldTitle.getText()
                        + "', username='" + jTextUsername.getText()
                        + "', pwd='" + ed.encryptString(password)
                        + "', mail='" + jTextEmail.getText()
                        + "', com='" + jTextComment.getText()
                        + "' WHERE id =" + entryId;

                System.out.println(sql);
                stm.executeUpdate(sql);
                System.out.println("INSERT complete");
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_jButtonConfirmActionPerformed

    private void jTextFieldPwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPwKeyReleased
        passwordBar1.setSecurityLevel(jTextFieldPw.getText());
    }//GEN-LAST:event_jTextFieldPwKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCancel1;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JLabel jLabelComment;
    private javax.swing.JLabel jLabelConfirmLabel;
    private javax.swing.JLabel jLabelEditEntry;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextComment;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextFieldPw;
    private javax.swing.JTextField jTextFieldPwConf;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JTextField jTextUsername;
    private main.java.de.frauas.progex.flatprotecc.PasswordBar passwordBar1;
    // End of variables declaration//GEN-END:variables
}