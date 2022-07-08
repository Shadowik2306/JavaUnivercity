import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class BadSortButILikeIt {
    public static String encoding(String s) {
        StringBuilder result = new StringBuilder();
        char key = 0;
        int value = 0;
        for (char c : s.toCharArray()) {
            if (key == c) {
                value++;
            }
            else {
                if (value != 0) {
                    result.append((char)key).append(String.valueOf(value)).append("|");
                }
                key = c;
                value = 1;
            }
        }
        result.append(key).append(String.valueOf(value));
        return result.toString();
    }

    public static String decoding(String s) {
        StringBuilder result = new StringBuilder();
        for (String item: s.split("\\|")
             ) {
            for (int i = 0; i < Integer.parseInt(item.substring(1)); i++) {
                result.append(item.charAt(0));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        try (FileReader reader = new FileReader("test.txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                s.append(String.valueOf((char)c));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String result = encoding(s.toString());
        System.out.println(result);

        try(FileWriter writer = new FileWriter("test1.txt", false))
        {
            writer.write(result.toString());

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        result = decoding(result);
        try(FileWriter writer = new FileWriter("test2.txt", false))
        {
            writer.write(result.toString());

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
