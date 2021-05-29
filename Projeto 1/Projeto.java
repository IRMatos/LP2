import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
    Figure focus = null;
    Random rand = new Random();

    ListFrame () {
        
	setFocusTraversalKeysEnabled(false);
  
	
	this.addMouseListener(
	    new MouseAdapter() {
		public void mousePressed (MouseEvent evt) { 
		    focus = null;
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
		    else if (evt.getKeyChar() == 'o') {
		        figs.add(new RoundRect(x, y, w, h, arcW, arcH, cfr, cfg, cfb, ccr, ccg, ccb));
		    	focus = figs.get(figs.size()-1);
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
    }
}
