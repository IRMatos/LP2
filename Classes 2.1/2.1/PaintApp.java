import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3, r4;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(100, 100, 110, 20, Color.yellow, Color.gray);
        this.r2 = new Rect(110, 90, 120, 30, Color.red, Color.orange);
        this.r3 = new Rect(120, 80, 130, 40, Color.cyan, Color.pink);
        this.r4 = new Rect(130, 70, 140, 50, Color.magenta, new Color(255, 60, 255));
        
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
        this.r4.paint(g);
    }
}

class Rect {
    int x, y;
    int l, a;
    Color contorno;
    Color fundo;

    Rect (int x, int y, int l, int a, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.a = a;
        this.contorno = contorno;
        this.fundo = fundo;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.l, this.a, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(contorno);
        g2d.drawRect(this.x,this.y, this.a,this.l);
        g2d.setColor(fundo);
        
        g2d.fillRect(x+5, y+5, a-5, l-5);
    }
}
