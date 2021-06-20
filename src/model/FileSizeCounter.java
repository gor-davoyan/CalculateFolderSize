package model;

import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Objects;

public class FileSizeCounter {
    long sizeOfFolder;
    long items;

    public long count(File file) {
        long size = 0;
        if (file.isDirectory()) {
            for (File value : Objects.requireNonNull(file.listFiles())) {
                if (value.isDirectory()) {
                    size += count(value);
                } else {
                    size += value.length();
                    sizeOfFolder += value.length();
                }
                items++;
            }
        } else {
            throw new RuntimeException("Wrong path!");
        }
        return size;
    }

    public String humanReadableByteCountSI(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }
}
