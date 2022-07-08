import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Translator {
    static JFileChooser chooser = new JFileChooser();
    public static void readFile() throws FileNotFoundException {
        Scanner scannerFile = null;
        File file = null;
        int ret = chooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        }
        scannerFile = new Scanner(file);

        HashSet<String> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        while (scannerFile.hasNext()) {
            String ch = scannerFile.next();
            for (char item :
                    ch.toCharArray()) {
                result.append(cyr2lat(item));
            }
            set.add(result.toString());
            result = new StringBuilder();
        }


        try (FileWriter writer = new FileWriter("result.txt", false)) {
            List<String> items = new ArrayList<>(set);
            Collections.shuffle(items);
            System.out.println(items.toString());
            for (String item:
                 items) {
                writer.write(item);
                writer.write(" ");
            }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String cyr2lat(char ch){
        String result;
        switch (Character.toUpperCase(ch)){
            case 'А': result = "A"; break;
            case 'Б': result = "B"; break;
            case 'В': result = "V"; break;
            case 'Г': result = "G"; break;
            case 'Д': result = "D"; break;
            case 'Е': result = "E"; break;
            case 'Ё': result = "JE"; break;
            case 'Ж': result = "ZH"; break;
            case 'З': result = "Z"; break;
            case 'И': result = "I"; break;
            case 'Й': result = "Y"; break;
            case 'К': result = "K"; break;
            case 'Л': result = "L"; break;
            case 'М': result = "M"; break;
            case 'Н': result = "N"; break;
            case 'О': result = "O"; break;
            case 'П': result = "P"; break;
            case 'Р': result = "R"; break;
            case 'С': result = "S"; break;
            case 'Т': result = "T"; break;
            case 'У': result = "U"; break;
            case 'Ф': result = "F"; break;
            case 'Х': result = "KH"; break;
            case 'Ц': result = "C"; break;
            case 'Ч': result = "CH"; break;
            case 'Ш': result = "SH"; break;
            case 'Щ': result = "JSH"; break;
            case 'Ъ': result = "HH"; break;
            case 'Ы': result = "IH"; break;
            case 'Ь': result = "JH"; break;
            case 'Э': result = "EH"; break;
            case 'Ю': result = "JU"; break;
            case 'Я': result = "JA"; break;
            default: result = Character.toString(ch); break;
        }
        StringBuilder fin = new StringBuilder();
        int i = 0;
        for (char item:
             result.toCharArray()) {
            if (i == 0) {
                if (Character.isUpperCase(ch)) {
                    fin.append(Character.toLowerCase(item));
                }
                else {
                    fin.append(Character.toUpperCase(item));
                }
            }
            else {
                if (Character.isUpperCase(ch)) {
                    fin.append(Character.toUpperCase(item));
                }
                else {
                    fin.append(Character.toLowerCase(item));
                }
            }
            i++;
        }
        return fin.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile();
    }
}
