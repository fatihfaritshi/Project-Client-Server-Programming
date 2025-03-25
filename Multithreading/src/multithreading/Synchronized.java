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

class TwoStrings {
    synchronized static void print(String str1, String str2, String color) {
        System.out.print(color + Thread.currentThread().getName() + ": " + str1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println(str2 + "\u001B[0m"); 
    }
}

class PrintStringsThread implements Runnable {
    private final String str1, str2, color;

    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String BLUE = "\u001B[34m";
    static final String YELLOW = "\u001B[33m";

    public PrintStringsThread(String str1, String str2, String color) {
        this.str1 = str1;
        this.str2 = str2;
        this.color = color;
    }

    public void run() {
        
        Thread.currentThread().setName("Thread");
        TwoStrings.print(str1, str2, color);
    }
}

public class Synchronized {
    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        
        executor.execute(new PrintStringsThread("Hello ", "there.", PrintStringsThread.RED));
        executor.execute(new PrintStringsThread("How are ", "you?", PrintStringsThread.GREEN));
        executor.execute(new PrintStringsThread("Thank you ", "very much!", PrintStringsThread.BLUE));

        executor.shutdown();
    }
}