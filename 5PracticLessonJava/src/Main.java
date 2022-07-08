import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Main extends JFrame {
    Main() {
        super();
        Canvas canvas = new Canvas();
        getContentPane().add(canvas);
        canvas.animationStart();
    }

    public static void main(String[] args) {
        Main win = new Main();
        win.pack();
        win.setSize(1000, 1000);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }

    class Canvas extends JComponent implements ActionListener {
        Timer timer = new Timer(50, this);
        int xBoat = 700, yBoat = 800;
        int xCloud = 500, yCloud = 650;
        int xIceberg = 100, yIceberg = 900;

        public void drawIceberg(Graphics g) {
            g.setColor(new Color(175, 238, 238));
            int arrX[] = {xIceberg, xIceberg + 50, xIceberg + 250};
            int arrY[] = {yIceberg, yIceberg - 400, yIceberg};
            g.fillPolygon(arrX, arrY, 3);
        }

        public void drawCloud(Graphics g) {
            g.setColor(new Color(175, 238, 238));
            g.fillOval(xCloud, yCloud, 150, 50);
        }

        public void drawBackground(Graphics g) {
            g.setColor(Color.blue);
            g.fillRect(0, 800, 1000, 200);
        }

        public void drawBoat(Graphics g) {
            g.setColor(Color.ORANGE);
            g.fillOval(xBoat, yBoat, 150, 60);
            g.fillRect(xBoat + 75, yBoat - 150, 20, 160) ;
            g.setColor(Color.green);
            int arrX[] = {xBoat + 75, xBoat + 50, xBoat + 75};
            int arrY[] = {yBoat - 150, yBoat - 100, yBoat - 50};
            g.fillPolygon(arrX, arrY, 3);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawBackground(g);
            drawCloud(g);
            drawBoat(g);
            drawIceberg(g);
            super.repaint();
        }

        public void animationStart() {
            timer.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            xBoat -= 3;
            xIceberg += 5;
            xCloud -=1;
        }
    }
}
