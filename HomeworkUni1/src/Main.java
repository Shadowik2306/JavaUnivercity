import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main extends JFrame {
    Main() {
        super("Массивы и прочая живность");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        mainPanel.setBackground(Color.RED);
        buttonPanel.setBackground(Color.RED);

        constraints.gridx = 1;
        buttonPanel.add(new JLabel("Размер:"));

        constraints.gridx = 2;
        JTextField textSize = new JTextField(5);
        buttonPanel.add(textSize, constraints);

        constraints.gridx = 3;
        JButton singleArrayButton = new JButton("Одномерный");
        singleArrayButton.setBackground(Color.BLACK);
        singleArrayButton.setForeground(Color.WHITE);
        buttonPanel.add(singleArrayButton, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        buttonPanel.add(new JLabel("Колл-во строк:"), constraints);

        constraints.gridx = 1;
        JTextField textSizeI = new JTextField(5);
        buttonPanel.add(textSizeI, constraints);

        constraints.gridx = 2;
        buttonPanel.add(new JLabel("Колл-во столбцов:"), constraints);

        constraints.gridx = 3;
        JTextField textSizeJ = new JTextField(5);
        buttonPanel.add(textSizeJ, constraints);

        constraints.gridx = 4;
        JButton doubleArrayButton = new JButton("Двумерный ");
        doubleArrayButton.setBackground(Color.BLUE);
        doubleArrayButton.setForeground(Color.WHITE);
        buttonPanel.add(doubleArrayButton, constraints);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        Font f1 = new Font("Times New Roman", Font.BOLD, 13);
        JLabel original = new JLabel();
        original.setFont(f1);
        original.setForeground(Color.magenta);
        mainPanel.add(original, BorderLayout.WEST);
        JLabel firstTask = new JLabel();
        firstTask.setFont(f1);
        firstTask.setForeground(Color.RED);
        mainPanel.add(firstTask, BorderLayout.CENTER);
        JLabel secondTask = new JLabel();
        secondTask.setFont(f1);
        secondTask.setForeground(Color.GREEN);
        mainPanel.add(secondTask, BorderLayout.EAST);



        singleArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String originalText;
                    SingleArray singleArray = new SingleArray(Integer.parseInt(textSize.getText()));
                    originalText = "<html>Оригинальный массив||<br><br>" + singleArray.print() + "</html>";
                    original.setText(originalText);

                    singleArray.swapElems();
                    String firstTaskText;
                    firstTaskText = "<html>Первое задание   <br><br>" + singleArray.print() + "</html>";
                    firstTask.setText(firstTaskText);

                    secondTask.setText("");

                }
                catch (Exception n) {
                    System.exit(0);
                }
            }
        });

        doubleArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String originalText;
                    DoubleArray doubleArray = new DoubleArray(Integer.parseInt(textSizeI.getText()),
                            Integer.parseInt(textSizeJ.getText()));
                    originalText = "<html>Оригинальный массив||<br><br>";
                    for (String item: doubleArray.NonHomeworkPrint()) {
                        originalText = originalText + item + "<br>";
                    }
                    originalText = originalText + "</html>";
                    original.setText(originalText);

                    doubleArray.sortArray();
                    String firstTaskText;
                    firstTaskText = "<html>Второе задание||<br><br>";
                    for (String item: doubleArray.NonHomeworkPrint()) {
                        firstTaskText = firstTaskText + item + "<br>";
                    }
                    firstTaskText = firstTaskText + "</html>";
                    firstTask.setText(firstTaskText);

                    doubleArray.swapElems();
                    String secondTaskText;
                    secondTaskText = "<html>Третье задание<br><br>";
                    for (String item: doubleArray.NonHomeworkPrint()) {
                        secondTaskText = secondTaskText + item + "<br>";
                    }
                    secondTaskText = secondTaskText + "</html>";
                    secondTask.setText(secondTaskText);


                }
                catch (Exception n) {
                    System.exit(0);
                }
            }
        });


        getContentPane().add(mainPanel);

    }

    public static void main(String[] args) {
        Main win = new Main();
        win.pack();
        win.setSize(500, 500);
        win.setVisible(true);
    }






}
