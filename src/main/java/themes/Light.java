package themes;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlContrastIJTheme;

import javax.swing.*;

public class Light implements Runnable {

    private int thread_number;

    public Light(int thread_number) {
        this.thread_number = thread_number;
    }

    @Override
    public void run() {
        System.out.println("Light mode is on!");
        for (int i = 0; 0 < 1; i++) {
            System.out.println("Light Theme[" + i + "] running at " + thread_number);
            try {
                UIManager.setLookAndFeel(new FlatLightOwlContrastIJTheme());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
