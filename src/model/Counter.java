package model;

import java.io.File;

public class Counter implements Runnable {
    private String path;
    private FileSizeCounter fsc;

    public Counter(String path, FileSizeCounter fsc) {
        this.path = path;
        this.fsc = fsc;
    }

    @Override
    public void run() {
        fsc.count(new File(path));
    }
}