package figures;

import java.awt.*;
import java.awt.Polygon;

public class Poligono extends Figure {
    int[] xPoint, yPoint;
    int npoints = 4;
    public Poligono (int x, int y, int w, int h, int cfr,int cfg, int cfb, int ccr, int ccg, int ccb) {
        super(x,y, w,h, cfr, cfg, cfb, ccr, ccg, ccb);
    }

    public void print () {
        for(int i = 0; i < npoints ; i++) {
            System.out.format("Poligono de (%d) lados nos pontos (%d,%d).\n",
            this.npoints, this.xPoint[i], this.yPoint[i]);
          }  
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        this.xPoint = new int[]{x + w/2 , x + w, x + w/2, x};
        this.yPoint = new int[]{y, y + h/2 , y + h, y + h/2 };
        if (focused){
            int[] xfocus = {x + w/2 , (x + w) + 2, x + w/2, x - 2};
            int[] yfocus = {y - 2 , y + h/2 , (y + h) + 2, y + h/2 };
            g2d.setPaint(Color.red);
            g2d.draw(new Polygon(xfocus, yfocus, this.npoints));
        }
        g2d.setColor(new Color(this.cfr,this.cfg,this.cfb));
        g2d.fill(new Polygon(this.xPoint, this.yPoint, this.npoints));
        g2d.setColor(new Color(this.ccr,this.ccg,this.ccb));
        g2d.draw(new Polygon(this.xPoint, this.yPoint, this.npoints));
    }
    
}
