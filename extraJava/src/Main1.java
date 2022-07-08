import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

class Node
{
    char ch;
    int freq;
    Node left = null, right = null;

    Node(char ch, int freq)
    {
        this.ch = ch;
        this.freq = freq;
    }

    public Node(char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
};

public class Main1 {
    public static int countMatches(String s, char o) {
        return s.length() - s.replace(String.valueOf(o), "").length();
    }

    public static void main(String[] args) {
        HashSet<Character> lst = new HashSet<>();
        StringBuilder s = new StringBuilder();
        try(FileReader reader = new FileReader("test.txt")) {
            int c;
            while((c=reader.read())!=-1){
                lst.add((char)c);
                s.append((char) c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }


        ArrayList<Character> sortedLst = (ArrayList<Character>)
                lst.stream().sorted(Comparator.comparingInt(o -> -countMatches(s.toString(), o))).collect(Collectors.toList());

        System.out.println(sortedLst);
    }



}

