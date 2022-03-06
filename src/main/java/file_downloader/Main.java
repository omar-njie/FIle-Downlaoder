package file_downloader;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Themes.dark_mode();
            new Ui();
        });
    }

}
