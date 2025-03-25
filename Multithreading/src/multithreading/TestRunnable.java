/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreading;

/**
 *
 * @author fatihfaritshi
 */
public class TestRunnable implements Runnable {
    private final Thread thread;
    private final String ANSI_COLOR;

    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m"; 

    public TestRunnable(String name, String color) {
        this.ANSI_COLOR = color;
        thread = new Thread(this, name);
        thread.start();
    }

    public void run() {
        String name = thread.getName();
        for (int i = 0; i < 100; i++) {
            System.out.print(ANSI_COLOR + name);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\u001B[0m"); 
    }

    public static void main(String[] args) {
        new TestRunnable("F", RED);
        new TestRunnable("A", YELLOW);
        new TestRunnable("T", GREEN);
        new TestRunnable("I", BLUE);
        new TestRunnable("H", PURPLE);
    }
}