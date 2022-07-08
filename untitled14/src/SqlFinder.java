import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class SqlFinder {
    static JFileChooser chooser = new JFileChooser();
    static char[] example;
    public static void readFile() throws IOException {
        Scanner scannerFile = null;
        File file = null;
        int ret = chooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        }
        scannerFile = new Scanner(file);

        Scanner in = new Scanner(System.in);
        example = in.nextLine().toCharArray();
        try (FileWriter writer = new FileWriter("result.txt", false)) {
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                if (checkWord(s)) {
                    writer.write(s + '\n');
                }

            }
        }
    }

    static private boolean checkWord(String word) {
        char[] chars = word.toCharArray();
        if (Character.isAlphabetic(example[0])) {
            if (example[0] != chars[0]) return false;
        }
        if (Character.isAlphabetic(example[example.length - 1])) {
            if (example[example.length - 1] != chars[chars.length - 1]) return false;
        }
        if (example.length == 2) {
            if (example[0] == '?' && example[1] == '?') {
                if (word.length() == 2) return true;
            }
            if (example[0] == '?' && Character.isAlphabetic(example[1])) {
                if (word.length() == 2) return true;
            }
            if (example[1] == '?' && Character.isAlphabetic(example[0])) {
                if (word.length() == 2) return true;
            }
        }
        else if (example.length == 3) {
            if (example[0] == '?' && example[1] == '?' && example[2] == '?') {
                if (word.length() == 3) return true;
            }
            if (Character.isAlphabetic(example[0]) && example[1] == '?' && example[2] == '?') {
                if (word.length() == 3) return true;
            }
            if (Character.isAlphabetic(example[2]) && example[1] == '?' && example[0] == '?') {
                if (word.length() == 3) return true;
            }
            if (Character.isAlphabetic(example[1]) && example[0] == '?' && example[2] == '?') {
                if (word.length() == 3) {
                    if (chars[1] == example[1]) return true;
                }
            }
            if (Character.isAlphabetic(example[0]) && Character.isAlphabetic(example[2]) && example[1] == '?') {
                if (word.length() == 3) return true;
            }
            if (Character.isAlphabetic(example[0]) && Character.isAlphabetic(example[1]) && example[2] == '?') {
                if (word.length() == 3) if (chars[1] == example[1]) return true;
            }
            if (Character.isAlphabetic(example[2]) && Character.isAlphabetic(example[1]) && example[0] == '?') {
                if (word.length() == 3) if (chars[1] == example[1]) return true;
            }
            if (example[0] == '*' && Character.isAlphabetic(example[1]) && example[2] == '?') {
                if (word.length() >= 3) {
                    for (int i = 1; i < word.length(); i++) {
                        if (chars[i] == example[1]) return true;
                    }
                }
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        readFile();
    }
}
