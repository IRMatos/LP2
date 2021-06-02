import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;

import figures.*;

class Projeto {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();
    Figure focus = null;
    Button focus_but = null;
    Random rand = new Random();
    int idx;

    ListFrame () {
	try {
		FileInputStream f = new FileInputStream("proj.bin");
	    ObjectInputStream o = new ObjectInputStream(f);
	    this.figs = (ArrayList<Figure>) o.readObject();
	    o.close();
	} catch (Exception x) {
	    System.out.println("ERRO!");
	}
	    
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
		    try {
		    FileOutputStream f = new FileOutputStream("proj.bin");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(figs);
			o.flush();
			o.close();
		    } catch (Exception x) {
		    }
                    System.exit(0);
                }
            }
        );
	
	setFocusTraversalKeysEnabled(false);
	    
	buts.add(new Button(1, new Ellipse(0,0,0,0,219,71,71,0,0,0)));
	buts.add(new Button(2, new Rect(0,0,0,0,52,203,87,0,0,0)));
	buts.add(new Button(3, new RoundRect(0,0,0,0,15,25,62,52,203,0,0,0)));
	buts.add(new Button(4, new Arc(0,0,0,0,150,240,0,0,0,0,0,0)));
	buts.add(new Button(5, new Poligono(0,0,0,0,145,20,20,0,0,0)));

	this.addMouseListener(
	    new MouseAdapter() {
		public void mousePressed (MouseEvent evt) { 
		    focus = null;
		    focus_but = null;
		    int x = evt.getX();
		    int y = evt.getY();
		    for (Figure fig: figs) {
		        if (fig.clicked(x,y)) {
			    	focus = fig;
			    	repaint();
			   	break;
                        }
			else {
			    focus = null;
			    repaint();
			}
		    }
		    for (Button but: buts) {
		        if (but.clicked(x,y)) {
			    focus_but = but;
			    repaint();
			    break;
			}
		    }
			
		    if (focus_but != null) {
		        if (focus_but.getidx() == 1) {
			    idx = 1;
			}
			else if (focus_but.getidx() == 2) {
			    idx = 2;
			}
			else if (focus_but.getidx() == 3) {
			    idx = 3;
			}
			else if (focus_but.getidx() == 4) {
			    idx = 4;
			}
			else if (focus_but.getidx() == 5) {
			    idx = 5;
			}

			}

		    repaint();

			if ((focus_but == null) && (focus == null)) {
				if (idx == 1) {
			    	figs.add(new Ellipse(x,y, rand.nextInt(50),rand.nextInt(50),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),0,0,0));
					focus = figs.get(figs.size()-1);
			}
		    	else if (idx == 2) {
			    	figs.add(new Rect(x,y, rand.nextInt(50),rand.nextInt(50),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),0,0,0));
					focus = figs.get(figs.size()-1);
			}
				else if (idx == 3) {
			    	figs.add(new RoundRect(x,y, rand.nextInt(50),rand.nextInt(50),20,15,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),0,0,0));
					focus = figs.get(figs.size()-1);
			}
				else if (idx == 4) {
			    	figs.add(new Arc(x,y, rand.nextInt(50),rand.nextInt(50), rand.nextInt(180),rand.nextInt(280),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),0,0,0));
			    	focus = figs.get(figs.size()-1);
		    }
				else if (idx == 5) {
					figs.add(new Poligono(x,y,rand.nextInt(50),rand.nextInt(50),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),0,0,0));
			    	focus = figs.get(figs.size()-1);
		    }
			
			idx = 0; 
		}

		    repaint();
		}
	    }
	);
	
	this.addMouseMotionListener(
	    new MouseMotionAdapter() {
	        public void mouseDragged (MouseEvent evt) {  
		    for (Figure fig: figs) {
		        if (focus == fig) {
			    focus.x = evt.getX()-focus.w/2;
			    focus.y = evt.getY()-focus.h/2;
			    repaint();
			}
		    }
		}
	    }
	);

        this.addKeyListener (
            new KeyAdapter() {
            public void keyPressed (KeyEvent evt) {
		    Point pos = getMousePosition();
		    int x = pos.x;
            int y = pos.y;
            int w = rand.nextInt(50);
            int h = rand.nextInt(50);
		    int arcW = 25;
		    int arcH = 10;
			int Angulo1 = rand.nextInt(180);
			int Angulo2 = rand.nextInt(280);
		    int cfr = rand.nextInt(255);
            int cfg = rand.nextInt(255);
            int cfb = rand.nextInt(255);
            int ccr = rand.nextInt(255);
		    int ccg = rand.nextInt(255);
		    int ccb = rand.nextInt(255);

		    
            if (evt.getKeyChar() == 'r') {
                figs.add(new Rect(x, y, w, h, cfr, cfg, cfb, ccr, ccg, ccb));
                focus = figs.get(figs.size()-1);
		    }
		    else if (evt.getKeyChar() == 'e') {
                figs.add(new Ellipse(x, y, w, h, cfr, cfg, cfb, ccr, ccg, ccb));
		    	focus = figs.get(figs.size()-1);
		    }
			else if (evt.getKeyChar() == 'k') {
		        figs.add(new Arc(x, y, w, h, Angulo1, Angulo2, cfr, cfg, cfb, ccr, ccg, ccb));
		    	focus = figs.get(figs.size()-1);
			}
		    else if (evt.getKeyChar() == 'o') {
		        figs.add(new RoundRect(x, y, w, h, arcW, arcH, cfr, cfg, cfb, ccr, ccg, ccb));
		    	focus = figs.get(figs.size()-1);
		    }
			else if(evt.getKeyChar()=='p') {
				figs.add(new Poligono(x,y,w,h,cfr, cfg, cfb, ccr, ccg, ccb));
				focus = figs.get(figs.size()-1);	
				
			}
			
			else if (evt.getKeyChar()== 'b'){
				figs.clear();
			}
	            for (Figure fig: figs) {
		        if (focus == fig) {
			    if (evt.getKeyCode() == KeyEvent.VK_DELETE) { 
			        figs.remove(fig);
				focus = null;
				repaint();
				break;
			    }
			    else if (evt.getKeyChar() == 'a') {  
				fig.drag(-1,0);
			    }
			    else if (evt.getKeyChar() == 'd') {  
				fig.drag(1,0);
			    }
			    else if (evt.getKeyChar() == 'w') {  
				fig.drag(0,-1);
			    }
			    else if (evt.getKeyChar() == 's') {  
				fig.drag(0,1);
			    }
			    else if (evt.getKeyChar() == '+') {  
				fig.resize(1,1);
			    }
			    else if (evt.getKeyChar() == '-') { 
				fig.resize(-1,-1);
			    }
			    else if (evt.getKeyChar() == 'f') {  
				fig.fundo(cfr,cfg,cfb);
			    }
			    else if (evt.getKeyChar() == 'c') {  
				fig.contorno(ccr,ccg,ccb);
			    }

			}
			else if (evt.getKeyCode() == KeyEvent.VK_TAB) {
			    focus = fig;
			    figs.remove(fig);
			    figs.add(fig);
			    break;
			}

		    }
		    repaint();
                }
            }
        );

        this.setTitle("Projeto - O Projeto.");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
        for (Figure fig: this.figs) {
            fig.paint(g, false);
        }
	
	if (focus != null) {  
	    focus.paint(g, true);  
	}
	for (Button but: this.buts) {
	    but.paint(g, but == focus_but);
	}
    }
}
