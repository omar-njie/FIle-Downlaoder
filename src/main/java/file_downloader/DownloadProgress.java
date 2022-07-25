package file_downloader;

import javax.swing.*;
import java.awt.*;

class DownloadProgress extends JFrame implements Runnable {
    private final JPanel main_panel = new JPanel();
    private final JProgressBar download_progressbar = new JProgressBar();
    private JLabel download_label;

    public DownloadProgress() {
        run();
    }

    private static void percent_counter(int total, int current) {
        while (current <= total) {
            double percent = (double) current / total;
            int percent_int = (int) (percent * 100);

            try {
                Thread.sleep(55);
                System.out.println("Downloading: " + percent_int + "%");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            current++;
        }
    }

    @Override
    public void run() {
        this.setTitle("Download Progress");
        this.setSize(395, 115);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        main_panel.setLayout(new BorderLayout());
        this.add(main_panel);

        Font font = new Font("JetBrainsMono Nerd Font Mono", Font.BOLD, 25);

        download_label = new JLabel("Downloading...", SwingConstants.CENTER);
        download_label.setFont(font);

        download_progressbar.setStringPainted(true);
        download_progressbar.setFont(font);

        main_panel.add(download_label, BorderLayout.NORTH);
        main_panel.add(download_progressbar, BorderLayout.CENTER);
        fill();
    }

    /**
     * <h2>Fill progress bar.</h2>
     * <h2>windows disposed after 1000ms depending on the download speed.</h2>
     */
    public void fill() {
        Thread thread = new Thread(() -> {
            int counter = 0;
            while (counter <= 100) {
                download_progressbar.setValue(counter);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter += 1;
            }
            download_progressbar.setString("Download Completed!");
            download_label.setText("Success!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.dispose();
        });
        percent_counter(100, 0);
        thread.start();
    }
}
