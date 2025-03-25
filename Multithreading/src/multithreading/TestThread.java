/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author fatihfaritshi
 */

class PrintNameRunnable implements Runnable {
    private final String name;
    private final String ANSI_COLOR;

    PrintNameRunnable(String name, String color) {
        this.name = name;
        this.ANSI_COLOR = color;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.print(ANSI_COLOR + name + " ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\u001B[0m"); 
    }
}

public class TestThread {
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newFixedThreadPool(5);

        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String BLUE = "\u001B[34m";
        String YELLOW = "\u001B[33m";
        String PURPLE = "\u001B[35m";

        executor.execute(new PrintNameRunnable("F", RED));
        executor.execute(new PrintNameRunnable("A", YELLOW));
        executor.execute(new PrintNameRunnable("T", GREEN));
        executor.execute(new PrintNameRunnable("I", BLUE));
        executor.execute(new PrintNameRunnable("H", PURPLE));

        executor.shutdown();
    }
}

