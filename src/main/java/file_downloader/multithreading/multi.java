package file_downloader.multithreading;

import javax.management.relation.RelationNotFoundException;

public class multi implements Runnable {

    private int thread_number;
    public multi(int thread_number) {
        this.thread_number = thread_number;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + " from thread " + thread_number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
