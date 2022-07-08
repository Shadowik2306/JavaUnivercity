import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WTF {
    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        try (FileReader reader = new FileReader("test.txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                if ((char) c == '\r') {
                    lst.add(s.toString());
                    s = new StringBuilder();
                }
                else {
                    s.append((char) c);
                }

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        if (!s.toString().equals("")) {
            lst.add(s.toString());
        }

        double middle = 0;
        int value = 0;

        for (String item: lst
             ) {
            middle += item.length();
            value++;
        }

        middle /= value;

        Scanner in = new Scanner(System.in);

        switch (in.nextInt()) {
            case (0):
                lst = (ArrayList<String>) lst.stream().sorted((String::compareTo)).collect(Collectors.toList());
                break;
            case (1):
                lst = (ArrayList<String>) lst.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
                break;
            case (3):
                ArrayList<String> finalLst = lst;
                lst = (ArrayList<String>) lst.stream().sorted((Comparator.comparingInt(o -> Collections.frequency(finalLst, o)))).collect(Collectors.toList());
                break;
            default:
                break;

        }

        HashSet<Character> sim = new HashSet<>(Arrays.asList('а', 'о', 'у', 'ы', 'э', 'я', 'е', 'ё', 'ю', 'и'));
        int val = 0;
        for (String item: lst) {

            if (item.length() >= middle) {
                for (int i = item.length() - 1; i >= 0; i--) {
                    if (sim.contains(Character.toLowerCase(item.charAt(i)))) {
                        if (Character.isLowerCase(item.charAt(i))) {
                            System.out.print(Character.toUpperCase(item.charAt(i)));
                        }
                        else {
                            System.out.print(Character.toLowerCase(item.charAt(i)));
                        }
                        val++;
                    }

                }
                System.out.print(" ");
                System.out.println(value);
            }
        }

    }
}
