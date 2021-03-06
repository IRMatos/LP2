import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame.*;
import java.awt.geom.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.getContentPane().setBackground( Color.black);
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setLocationRelativeTo(null); 
        
    }



    public void paint (Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        int w = getWidth();
        int h = getHeight();
        g2d. setStroke (new BasicStroke(10));
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
        g2d.setFont(new Font("Arial", Font.ITALIC,35));
        g2d.setColor(Color.green);
        g2d.drawString("LP2",155,100);
        g2d.setPaint(Color.yellow);
        g2d.draw(new Rectangle2D.Double(70,50,200,200));
    }
}
