import model.Counter;
import model.FileSizeCounter;
import model.Updater;

public class Main {

    public static void main(String[] args) {
        FileSizeCounter fsc = new FileSizeCounter();
        String path = "/home/gor/Android";
        Thread t1 = new Thread(new Counter(path, fsc));
        Thread t2 = new Thread(new Updater(fsc, t1));
        t1.start();
        t2.start();
    }
}
