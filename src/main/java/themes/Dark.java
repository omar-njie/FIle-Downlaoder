package themes;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanContrastIJTheme;

import javax.swing.*;

public class Dark implements Runnable {

    private final int thread_number;

    public Dark(int thread_number) {
        this.thread_number = thread_number;
    }

    @Override
    public void run() {
        System.out.println("Dark mode is on!");
        for (int i = 0; i <= 1; i++) {
            System.out.println("Dark Theme [" + i + "] running at " + thread_number);
            try {
                UIManager.setLookAndFeel(new FlatMaterialDeepOceanContrastIJTheme());
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