import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(70);
                    int h = rand.nextInt(70);
                    
                    int x1 = rand.nextInt(300);
                    int x2 = rand.nextInt(400);
                    int x3 = rand.nextInt(150);
                    int y1 = rand.nextInt(100);
                    int y2 = rand.nextInt(200);
                    int y3 = rand.nextInt(250);
                    
                    Color contorno = new Color(rand.nextInt(125), rand.nextInt(125), rand.nextInt(125));
                    Color fundo = new Color(rand.nextInt(300), rand.nextInt(300), rand.nextInt(300));
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x, y, w, h));
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x, y, w, h));
                    } else if (evt.getKeyChar() == 't') {
                    	figs.add(new Triangl(x1, x2, x3, y1, y2,y3, fundo));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras Heterogenea");
        this.setSize(410, 410);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
