import model.Counter;
import model.FileSizeCounter;
import model.Updater;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter folder path:");
        FileSizeCounter fsc = new FileSizeCounter();
        Thread t1 = new Thread(new Counter(sc.next(), fsc));
        Thread t2 = new Thread(new Updater(fsc, t1));
        t1.start();
        t2.start();
    }
}
