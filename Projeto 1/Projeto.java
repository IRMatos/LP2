import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import figures.*;
import java.util.Random;

public class Projeto extends JFrame {

    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figs = new ArrayList<>();
    Random rand= new Random ();
    Figure foco = null;
    Rect focoretang = null;

    Point ponto = null;
    Point pontoant = null, pontodps = null;

    int distanciaX = 0, distanciaY = 0;
    int iFundo = 1, jContorno = 0;

    Projeto () {
        this.addWindowListener (
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        this.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        pontoant = getMousePosition();
                        int x = pontoant.x;
                        int y = pontoant.y;

                        foco = null;
                        for (Figure fig: figs) {
                            boolean insideFigure = fig.x <= x && x <= (fig.x + fig.h) && fig.y <= y && y <= (fig.y + fig.w);
                            if (insideFigure) {
                                foco = fig;
                            }
                        }

                        if (foco != null) {
                            figs.remove(foco);
                            figs.add(foco);
                            distanciaX = foco.x - x;
                            distanciaY = foco.y - y;
                        }

                        repaint();
                    }
                }
        );

        this.addMouseMotionListener(
                new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        pontodps = getMousePosition();
                        int newX = pontodps.x;
                        int newY = pontodps.y;

                        if (foco != null) {
                            figs.remove(foco);
                            foco.x = newX + distanciaX;
                            foco.y = newY + distanciaY;
                            figs.add(foco);
                            repaint();
                        }
                    }
                }
        );

        this.addKeyListener (
                new KeyAdapter() {
                    @Override
                    public void keyPressed (KeyEvent evt) {
                        ponto = getMousePosition();
                        int x = ponto.x;
                        int y = ponto.y;
                        int w = 100;
                        int h = 100;

                        int letra = evt.getKeyChar();
                        int tecla = evt.getKeyCode();

                        if (letra == 'r') { 
                            figs.add(new Rect(x, y, w, h, new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)), 
                            new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255))));
                        }

                        else if (letra == 'e') { 
                            figs.add(new Elipse(x, y, w, h,new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)), 
                            new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255))));
                        }

                        else if (letra == 'l') {
                            figs.add(new Linha(x, y, w, h, new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255))
                            ));
                        }

                        else if (letra == 't') {
                            figs.add(new Triangulo(x, y, w, h, new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)), 
                            new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255))));
                        }

                        if (letra == 'r' || letra == 'e' || letra == 't' || letra == 'l' ) {
                            foco = figs.get(figs.size() - 1);
                        }

                        else if (tecla == 104 && foco != null) { 
                            if (iFundo >= 10){
                                iFundo = 0;
                                foco.cordefundo = Color.get(iFundo);
                                iFundo++;
                            }
                        }

                        else if (tecla == 98 && foco != null) { 
                            if (jContorno >= 10){
                                jContorno = 0;
                                foco.contorno = Color.get(jContorno);
                                jContorno++;
                            }
                        } 

                        else if (tecla == 37 && foco != null) { 
                            foco.x -= 10;
                        }

                        else if (tecla == 38 && foco != null) { 
                            foco.y -= 10;
                        }

                        else if (tecla == 39 && foco != null) { 
                            foco.x += 10;
                        }

                        else if (tecla == 40 && foco != null) { 
                            foco.y += 10;
                        }

                        else if (evt.getKeyChar() == '-' && foco != null) {
                            if (foco.w > 10 && foco.h > 10) {
                                foco.w -= 10;
                                foco.h -= 10;
                            }
                        }

                        else if (evt.getKeyChar() == '+' && foco != null) { 
                            if (foco. w != 0 && foco.h != 0) {
                                foco.w += 10;
                                foco.h += 10;
                            }
                        }

                        else if (chave == 145 && foco != null) { 
                            foco.w = 50;
                            foco.h = 50;
                        }

                        else if (chave == 127 && foco != null) { 
                            figs.remove(foco);
                            foco = null;
                            focoretang = null;
                        }

                        repaint();
                    }
                }
        );

        this.setTitle("Projeto 1");
        this.setSize(500, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }

        if (foco != null) {
            focoretang = new Rect(foco.x-5, foco.y-5, foco.w+10, foco.h+10, null, Color.red);
            focoretang.redFocus(g);
        }
    }
}
