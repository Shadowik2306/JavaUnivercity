import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;


class LengthSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}


class CountOfRepeat implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int freq1 = Collections.frequency(Filter.words, o1);
        int freq2 = Collections.frequency(Filter.words, o2);
        return freq2 - freq1;
    }
}


public class Filter {
    static JFileChooser chooser = new JFileChooser();
    static List<String> words;
    public static void readFile() throws IOException {
        Scanner scannerFile = null;
        File file = null;
        int ret = chooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        }
        scannerFile = new Scanner(file);

        Scanner in = new Scanner(System.in);
        words = new ArrayList<>();

        while (scannerFile.hasNext()) {
            String s = scannerFile.next();
            if (s.length() > 3) {
                words.add(s);
            }
        }

        int filterRule = in.nextInt();
        switch (filterRule) {
            case 1:
                Collections.sort(words); break;
            case 2:
                words.sort(new LengthSort()); break;
            case 3:
                words.sort(new CountOfRepeat()); break;
        }

        try (FileWriter writer = new FileWriter("result.txt", false)) {
            words.forEach(s -> {
                try {
                    writer.write(s + '\n');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}
