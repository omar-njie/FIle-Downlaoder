package file_downloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class Downloader {

    Downloader(URL url, String file_name) throws Exception {
        new DownloadProgress(100, 0);
        FileUtils.copyURLToFile(url, new File(file_name));
        System.out.println("Download Completed Successfully!!!");
    }
}