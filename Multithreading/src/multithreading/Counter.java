/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreading;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author fatihfaritshi
 */
public class Counter {
    public static void main(String[] args) {
        // Menjalankan GUI di event-dispatch thread
        SwingUtilities.invokeLater(() -> {
            CountDownGUI cdg = new CountDownGUI("COUNT DOWN");
            cdg.startCount();
        });
    }
}

class CountDownGUI extends JFrame {
    private JLabel label;

    CountDownGUI(String title) {
        super(title);

        // Inisialisasi label
        label = new JLabel("Start count!", SwingConstants.CENTER);

        // Konfigurasi JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(label, BorderLayout.CENTER);
        setSize(300, 200);
        setLocationRelativeTo(null); // Pusatkan jendela
        setVisible(true);
    }

    void startCount() {
        new Thread(() -> {
            try {
                for (int i = 10; i > 0; i--) {
                    final int count = i;
                    Thread.sleep(1000);
                    SwingUtilities.invokeLater(() -> label.setText(String.valueOf(count)));
                }
                Thread.sleep(1000);
                SwingUtilities.invokeLater(() -> label.setText("Count down complete."));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }).start();
    }
}