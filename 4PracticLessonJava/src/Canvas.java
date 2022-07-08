import javax.swing.*;
import java.awt.*;

public class Canvas extends JComponent {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D turtle = (Graphics2D) g;
        int[] x = {250, 300, 300, 200, 200};
        int[] y = {250, 300, 350, 350, 300};
        turtle.drawPolygon(x, y, x.length);
        super.repaint();
    }
}
