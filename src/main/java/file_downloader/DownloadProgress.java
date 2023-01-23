package file_downloader;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class DownloadProgress extends JFrame {
    private final JPanel main_panel = new JPanel();
    private final JProgressBar download_progress_bar = new JProgressBar();
    private JLabel download_label;

    public DownloadProgress(int total, int current) {
        init_ui();
        update_download_progress(total, current);
    }

    private void init_ui() {
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

        download_progress_bar.setStringPainted(true);
        download_progress_bar.setFont(font);

        main_panel.add(download_label, BorderLayout.NORTH);
        main_panel.add(download_progress_bar, BorderLayout.CENTER);
    }

    public void update_download_progress(int total, int current) {
        if (total == 0) {
            download_progress_bar.setIndeterminate(true);
            return;
        }
        download_progress_bar.setMaximum(total);
        download_progress_bar.setValue(current);
        final int[] current_final = {current};
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (current_final[0] <= total) {
                double percent = (double) current_final[0] / total;
                int percentInt = (int) (percent * 100);
                download_progress_bar.setValue(current_final[0]);
                download_progress_bar.setString(percentInt + "% Complete");
                current_final[0]++;
            } else {
                download_progress_bar.setString("Download Completed!");
                download_label.setText("Success!");
                executor.shutdown();
                ScheduledExecutorService closeExecutor = Executors.newSingleThreadScheduledExecutor();
                closeExecutor.schedule(this::dispose, 1, TimeUnit.SECONDS);
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
}
