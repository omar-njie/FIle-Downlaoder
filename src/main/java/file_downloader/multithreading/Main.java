package file_downloader.multithreading;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <= 5; i++) {
            multi multi_thread = new multi(i);
            Thread thread = new Thread(multi_thread);
            thread.start();
            thread.join();

        }
    }
}
