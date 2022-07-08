import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main extends JFrame {
    private JCheckBox italicBox = new JCheckBox("Italic");
    private JCheckBox boldBox = new JCheckBox("Bold");
    private JCheckBox underlineBox = new JCheckBox("Underline");
    private JButton applySettings = new JButton("Применить");
    private JLabel label = new JLabel(getText(), JLabel.CENTER);

    public Main() {
        super();
        setWin();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Main win = new Main();
        win.pack();
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }

    public void setWin() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.add(label, BorderLayout.NORTH);

        JPanel chBoxPanel = new JPanel();

        panel.add(applySettings, BorderLayout.CENTER);
        applySettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateText();
            }
        });

        chBoxPanel.add(italicBox);
        chBoxPanel.add(boldBox);
        chBoxPanel.add(underlineBox);

        panel.add(chBoxPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);

    }

    public void updateText() {
        label.setText(getText());
    }

    public String getText() {
        String text = "Съешь ещё этих мягких французских булок,<br>да выпей же чаю.";
        if (italicBox.isSelected()) text = "<em>" + text + "</em>";
        if (boldBox.isSelected()) text = "<strong>" + text + "</strong>";
        if (underlineBox.isSelected()) text = "<span style=\"text-decoration: underline;\">" + text + "</span>";
        return "<html>" + text + "</html>";
    }
}
