package file_downloader;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.net.URL;

public class Downloader {

    Downloader(URL url, String file_name) throws Exception {
        new DownloadProgress();
        FileUtils.copyURLToFile(url, new File(file_name));
        System.out.println("Download Completed Successfully!!!");
    }
}