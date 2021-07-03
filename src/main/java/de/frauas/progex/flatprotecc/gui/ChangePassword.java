/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.de.frauas.progex.flatprotecc.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import main.java.de.frauas.progex.flatprotecc.Connect2DB;
import main.java.de.frauas.progex.flatprotecc.MailSender;
import main.java.de.frauas.progex.flatprotecc.PasswordManager;
import main.java.de.frauas.progex.flatprotecc.ValidationCodeGenerator;

/**
 *
 * @author ana
 */
public class ChangePassword extends javax.swing.JFrame {
    private final int userId;
    /**
     * Creates new form ChangePassword
     */
    public ChangePassword(int _userId) {
        initComponents();
        
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        userId = _userId;
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
        jLabelOldPassword = new javax.swing.JLabel();
        jLabelNewPassword = new javax.swing.JLabel();
        jLabelNewPasswordConf = new javax.swing.JLabel();
        jFieldNewPasswordConf = new javax.swing.JPasswordField();
        jLabelChangePassword = new javax.swing.JLabel();
        jFieldOldPassword = new javax.swing.JPasswordField();
        jFieldNewPassword = new javax.swing.JPasswordField();
        jButtonConfirm = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FLATprotecc - Password Manager");
        setMinimumSize(new java.awt.Dimension(300, 250));

        jLabelOldPassword.setText("Old Password");

        jLabelNewPassword.setText("New Password");

        jLabelNewPasswordConf.setText("Confirm New Password");

        jLabelChangePassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelChangePassword.setText("Change Password");

        jFieldNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldNewPasswordActionPerformed(evt);
            }
        });

        jButtonConfirm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonConfirm.setText("Confirm");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });

        jButtonCancel.setBackground(new java.awt.Color(255, 0, 0));
        jButtonCancel.setText("Cancel");
        jButtonCancel.setMaximumSize(new java.awt.Dimension(77, 23));
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelOldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNewPasswordConf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFieldNewPasswordConf, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jFieldOldPassword)
                    .addComponent(jFieldNewPassword))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButtonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelChangePassword)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOldPassword)
                    .addComponent(jFieldOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNewPassword)
                    .addComponent(jFieldNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNewPasswordConf)
                    .addComponent(jFieldNewPasswordConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirm)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        String tmp = new String(jFieldOldPassword.getPassword());
        PasswordManager pwm = new PasswordManager();
        MailSender sender = new MailSender();
        ValidationCodeGenerator gen = new ValidationCodeGenerator();
        gen.generateNewValidationCode();

        try {
            Connect2DB connCreator = new Connect2DB();
            Connection conn = connCreator.StartConnection();
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM accounts WHERE id='" + userId + "';");
            rs.next();

            if (!String.valueOf(jFieldNewPassword.getPassword()).equals(String.valueOf(jFieldNewPasswordConf.getPassword()))) {       //New Password match
                JOptionPane.showMessageDialog(null, "Email does not match with confirmed email!", "Email Change", JOptionPane.ERROR_MESSAGE);
            }  else if (String.valueOf(jFieldNewPassword.getPassword()).length() < 8) {
                JOptionPane.showMessageDialog(null, "Please enter a password with at least 8 characters", "Registration failed", JOptionPane.ERROR_MESSAGE);
            } else if (!pwm.verifyPassword(tmp, rs.getString("hashValue"), rs.getString("salt"))) {      //Verify Password
                JOptionPane.showMessageDialog(null, "Password wrong! Please try again.", "Authentification failed", JOptionPane.ERROR_MESSAGE);
            } else if (sender.sendValidationCode(rs.getString("mail"), gen.getValidationCode())) {      //2 Factor Auth
                String validationCode = JOptionPane.showInputDialog(null, "Enter Validation-Code:", "2-Factor-Authentification", JOptionPane.QUESTION_MESSAGE);
                if (validationCode.equals(gen.getValidationCode())) {
                    String salt = pwm.getNewSalt();
                    stm = conn.createStatement();
                    String sql = "UPDATE accounts SET salt = '" + salt
                            + "' , hashValue = '" + pwm.hash(new String(jFieldNewPassword.getPassword()), salt)
                            + "' WHERE id = " + userId + ";";
                    System.out.println(sql);
                    
                    stm.executeUpdate(sql);
                    System.out.println("UPDATE complete");

                    JOptionPane.showMessageDialog(null, "Password changed sucessfully!", "Change Password", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong or expired code! Please try again.", "2-Factor-Authentification", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            System.out.println("CHANGE EMAIL SQL EXCEPTION");
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButtonConfirmActionPerformed

    private void jFieldNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldNewPasswordActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jFieldNewPasswordActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JPasswordField jFieldNewPassword;
    private javax.swing.JPasswordField jFieldNewPasswordConf;
    private javax.swing.JPasswordField jFieldOldPassword;
    private javax.swing.JLabel jLabelChangePassword;
    private javax.swing.JLabel jLabelNewPassword;
    private javax.swing.JLabel jLabelNewPasswordConf;
    private javax.swing.JLabel jLabelOldPassword;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
