package file_downloader;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Dark dark_mode = new Dark();
            //dark_mode.run();
            new Settings();
            new Ui();
        });
    }
}
