/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.de.frauas.progex.flatprotecc.gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import main.java.de.frauas.progex.flatprotecc.*;
/**
 *
 * @author lucas
 */
public class LoginScreen extends javax.swing.JFrame {

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
        initComponents();
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
        jLabelLogin = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jButtonCreateNewAccount = new javax.swing.JButton();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FLATprotecc - Password Manager");
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(250, 300));

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogin.setText("Login");

        jTextFieldEmail.setMaximumSize(null);

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonCreateNewAccount.setText("Create new account");
        jButtonCreateNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateNewAccountActionPerformed(evt);
            }
        });

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelEmail.setText("Email");

        jLabelPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPassword.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCreateNewAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addComponent(jPasswordField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelLogin)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonLogin)
                .addGap(28, 28, 28)
                .addComponent(jButtonCreateNewAccount)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        System.out.println("############################");
        System.out.println("Verbindung zu DB erfolgreich!");
        System.out.println("############################");
        Connect2DB connCreator = new Connect2DB();
        Connection conn = connCreator.StartConnection();
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM accounts WHERE mail='" + jTextFieldEmail.getText() + "';");
            rs.next();
            System.out.print("hash = " + rs.getString("hashValue") + "Mail eingabe : " + jTextFieldEmail.getText());
            byte[] salt = rs.getBytes("salt");
            System.out.print("SALTLOGIN =");
            for(int i=0; i< salt.length ; i++) {
            System.out.print(salt[i]);
            }
            System.out.println();
            
            String tmp = String.valueOf(jPasswordField.getPassword());
            PasswordManager pwm = new PasswordManager();
            if(pwm.verifyPassword(tmp, rs.getString("hashValue"), rs.getBytes("salt"))) { //TODO check email + password
            
                //send mail and generate validation code
                MailSender sender = new MailSender();
                ValidationCodeGenerator gen = new ValidationCodeGenerator();

                gen.generateNewValidationCode();

                if(sender.sendValidationCode(jTextFieldEmail.getText(), gen.getValidationCode())) {

                    String validationCode = JOptionPane.showInputDialog(null,"Enter Validation-Code:","2-Factor-Authentification", JOptionPane.QUESTION_MESSAGE);
                    // check validation code correct
                    int userId = rs.getInt("id");
                    if(validationCode.equals(gen.getValidationCode())) {
                        java.awt.EventQueue.invokeLater(new Runnable() { // Open OverviewScreen
                            public void run() {
                                new OverviewScreen(userId).setVisible(true);
                            }
                        });

                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null,"Wrong Code! Please try again.","2-Factor-Authentification", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Please enter a valid email","2-Factor-Authentification failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Password wrong! Please try again.","Login failed", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex){
            System.out.println("LoginScreen");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            JOptionPane.showMessageDialog(null,"Email wrong! Please try again.","Login failed", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonCreateNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateNewAccountActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() { // Open RegistrationScreen
            public void run() {
                new RegistrationScreen().setVisible(true);
            }
        });
        
        this.dispose();
        
    }//GEN-LAST:event_jButtonCreateNewAccountActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateNewAccount;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}
