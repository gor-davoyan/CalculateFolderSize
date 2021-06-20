package model;

import model.FileSizeCounter;

public class Updater implements Runnable {
    private FileSizeCounter fsc;
    private Thread t1;

    public Updater(FileSizeCounter fsc, Thread t1) {
        this.fsc = fsc;
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (t1.isAlive()) {
            System.out.println("Size of the folder: " + fsc.humanReadableByteCountSI(fsc.sizeOfFolder));
            System.out.println(fsc.items + " items");
            System.out.println("----------------------------");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Size of the folder: " + fsc.humanReadableByteCountSI(fsc.sizeOfFolder));
        System.out.println(fsc.items + " items");
    }
}
