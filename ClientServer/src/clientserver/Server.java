/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clientserver;
import static clientserver.Client.din;
import static clientserver.Client.dout;
import static clientserver.Client.s;
import java.net.ServerSocket;
import java.net.Socket; 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JovankaSabilaPertiwi
 */
public class Server extends javax.swing.JFrame {

    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    public Server() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InputS = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaS = new javax.swing.JTextArea();
        SendBtnS = new javax.swing.JButton();
        LableS = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));

        InputS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputSActionPerformed(evt);
            }
        });

        TextAreaS.setColumns(20);
        TextAreaS.setRows(5);
        jScrollPane1.setViewportView(TextAreaS);

        SendBtnS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SendBtnS.setText("SEND");
        SendBtnS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SendBtnSMouseClicked(evt);
            }
        });
        SendBtnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendBtnSActionPerformed(evt);
            }
        });

        LableS.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        LableS.setText("SERVER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InputS)
                        .addGap(18, 18, 18)
                        .addComponent(SendBtnS)))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(LableS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SendBtnS))
                .addGap(18, 18, 18)
                .addComponent(LableS)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendBtnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendBtnSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SendBtnSActionPerformed

    private void InputSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputSActionPerformed

    private void SendBtnSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendBtnSMouseClicked
       
        try {
            String msgout ="";
            msgout = InputS.getText().trim();
            dout.writeUTF(msgout);
        }
        catch (Exception e) {
        }
    }//GEN-LAST:event_SendBtnSMouseClicked

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
        
        try{
            ss = new ServerSocket(60119);
            s = ss.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
            String msgin ="";
            while (!msgin.equals("exit")){
                msgin = din.readUTF();
                TextAreaS.setText(TextAreaS.getText().trim() + "\n CLIENT:\t" + msgin);
            }
        } catch (Exception e) {
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField InputS;
    private static javax.swing.JLabel LableS;
    private static javax.swing.JButton SendBtnS;
    private static javax.swing.JTextArea TextAreaS;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
