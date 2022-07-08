import java.io.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<ArrayList<String>> transpose(ArrayList<ArrayList<String>> matrixIn) {
        ArrayList<ArrayList<String>> matrixOut = new ArrayList<ArrayList<String>>();
        if (!matrixIn.isEmpty()) {
            int noOfElementsInList = matrixIn.get(0).size();
            for (int i = 0; i < noOfElementsInList; i++) {
                ArrayList<String> col = new ArrayList<String>();
                for (ArrayList<String> row : matrixIn) {
                    col.add(row.get(i));
                }
                matrixOut.add(col);
            }
        }

        return matrixOut;
    }

    public static void main(String[] args) {
        int col = 0;
        ArrayList<ArrayList<String>> lst = new ArrayList<>();
        lst.add(new ArrayList<String>());
        StringBuilder save = new StringBuilder();
        try(FileReader reader = new FileReader("test.txt"))
        {
            // читаем посимвольно
            int c;

            while((c=reader.read())!=-1){
                if ((char)c == '\n') {
                    save = new StringBuilder();
                    continue;
                }
                if ((char)c == '\r') {
                    if (!save.toString().equals("")) {
                        lst.get(col).add(save.toString());
                    }
                    lst.add(new ArrayList<String>());
                    col++;
                }
                else {
                    if (!((char)c == ' ')) {
                        save.append(String.valueOf((char) c));
                    }
                    else {
                        if (save.toString().equals("")) {
                            save.append(" ");
                            continue;
                        }
                        lst.get(col).add(save.toString());
                        save = new StringBuilder();
                    }
                }
            }
            if (!save.toString().equals("")) {
                lst.get(col).add(save.toString());
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.get(i).size(); j++) {
                System.out.print(lst.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("-------------");

        lst = transpose(lst);
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.get(i).size(); j++) {
                System.out.print(lst.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }

        try(FileWriter writer = new FileWriter("test1.txt", false))
        {
            // запись всей строки
            for (int i = 0; i < lst.size(); i++) {
                for (int j = 0; j < lst.get(i).size(); j++) {
                    for (int k = 0; k < lst.get(i).get(j).length(); k++) {
                        writer.write(lst.get(i).get(j).substring(k, k));
                    }
                    writer.write(" ");
                }
                writer.write("\n");
            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}