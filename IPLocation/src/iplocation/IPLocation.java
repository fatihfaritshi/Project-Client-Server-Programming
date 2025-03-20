/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iplocation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class IPLocation extends JFrame {
    private JTextField txtHostName, txtIPAddress, txtServerLocation;
    private JButton btnFindIP;

    public IPLocation() {
        setTitle("IP DETECTION");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        getContentPane().setBackground(new Color(0, 0, 51));
        Border textFieldBorder = new LineBorder(new Color(153, 153, 255), 3, true);

        // Label Judul
        JLabel lblTitle = new JLabel("IP DETECTION");
        lblTitle.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(125, 20, 200, 30);
        add(lblTitle);

        // Label dan Text Field
        JLabel lblHostName = new JLabel("Host Name   :");
        lblHostName.setForeground(Color.WHITE);
        lblHostName.setBounds(50, 70, 100, 25);
         add(lblHostName);

        txtHostName = new JTextField();
        txtHostName.setBounds(160, 70, 180, 25);
        txtHostName.setBorder(textFieldBorder);
        add(txtHostName);

        JLabel lblIPAddress = new JLabel("IP Address   :");
        lblIPAddress.setForeground(Color.WHITE);
        lblIPAddress.setBounds(50, 110, 100, 25);
        add(lblIPAddress);

        txtIPAddress = new JTextField();
        txtIPAddress.setBounds(160, 110, 180, 25);
        txtIPAddress.setEditable(false);
        txtIPAddress.setBorder(textFieldBorder);
        add(txtIPAddress);

        JLabel lblServerLocation = new JLabel("Server Location");
        lblServerLocation.setForeground(Color.WHITE);
        lblServerLocation.setBounds(50, 150, 120, 25);
        add(lblServerLocation);

        txtServerLocation = new JTextField();
        txtServerLocation.setBounds(160, 150, 180, 25);
        txtServerLocation.setEditable(false);
        txtServerLocation.setBorder(textFieldBorder);
        add(txtServerLocation);

        // Tombol Find IP
        btnFindIP = new JButton("Find IP");
        btnFindIP.setBounds(240, 200, 100, 30);
        btnFindIP.setBackground(new Color(153, 153, 255));
        btnFindIP.setForeground(new Color(0, 0, 51));
        add(btnFindIP);

        // Action Listener
        btnFindIP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findIPAddress();
            }
        });
    }

    // Metode untuk mencari IP Address
    private void findIPAddress() {
        String hostName = txtHostName.getText().trim();
        if (hostName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan Host Name terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            InetAddress address = InetAddress.getByName(hostName);
            txtIPAddress.setText(address.getHostAddress());
            txtServerLocation.setText(address.getCanonicalHostName());
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(this, "Host Name tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IPLocation().setVisible(true));
    }
}
