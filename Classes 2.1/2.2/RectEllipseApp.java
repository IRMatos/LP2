import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;
    Ellipse e4;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        
        this.e1 = new Ellipse(100, 190, 120, 100, Color.magenta, Color.blue);
        this.e2 = new Ellipse(150, 200, 100, 90, Color.black, Color.pink);
        this.e3 = new Ellipse(130, 220, 80, 100, Color.orange, new Color(0, 0, 255));
        this.e4 = new Ellipse(110, 210, 60, 80, Color.magenta, new Color(200, 255, 20));
        
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        this.e4.paint(g);
    }
}

class Rect {
    int x, y;
    int l, a;

    Rect (int x, int y, int l, int a) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.a = a;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.l, this.a, this.x, this.y);
    }

    void paint (Graphics g) {
        g.drawRect(this.x,this.y, this.l,this.a);
    }
}

class Ellipse {
    int x, y;
    int l, a;
    Color contorno;
    Color fundo;

    Ellipse (int x, int y, int l, int a, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.a = a;
        this.contorno = contorno;
        this.fundo = fundo;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.l, this.a, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(contorno);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.l,this.a));
        g2d.setColor(fundo);
        g2d.fillOval(x, y, l, a);
    }
}
