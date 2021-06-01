package figures;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;

public class Arc extends Figure {
    private int Angulo1, Angulo2;

    public Arc (int x, int y, int w, int h, int Angulo1, int Angulo2, int cfr, int cfg, int cfb, int ccr, int ccg, int ccb)  {
        super(x, y, w, h, cfr, cfg, cfb, ccr, ccg, ccb);
        this.Angulo1 = Angulo1;
        this.Angulo2 = Angulo2;
    }

    private void print () {
        System.out.format("Arco de tamanho (%d,%d) na posição (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	
	if (focused) {
	    g2d.setPaint(Color.BLUE);
	    g2d.draw(new Arc2D.Double(this.x-3,this.y-3, this.w+6,this.h+6, this.Angulo1,this.Angulo2, Arc2D.PIE));
        }
	
	g2d.setColor(new Color(this.cfr,this.cfg,this.cfb));
	g2d.fill(new Arc2D.Double(this.x,this.y, this.w,this.h, this.Angulo1,this.Angulo2, Arc2D.PIE));
    g2d.draw(new Arc2D.Double(this.x,this.y, this.w,this.h, this.Angulo1,this.Angulo2, Arc2D.PIE));
	g2d.setColor(new Color(this.ccr,this.ccg,this.ccb));
    g2d.draw(new Arc2D.Double(this.x,this.y, this.w,this.h, this.Angulo1,this.Angulo2, Arc2D.PIE));
    }
}
