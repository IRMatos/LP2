package figures;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;

public class RoundRect extends Figure {
    private int arcW, arcH;

public RoundRect (int x, int y, int w, int h, int arcW, int arcH, int cfr, int cfg, int cfb, int ccr, int ccg, int ccb) {
  super(x, y, w, h, cfr, cfg, cfb, ccr, ccg, ccb);
	this.arcW = arcW;
	this.arcH = arcH;
    }

    private void print () {
        System.out.format("Retangulo redondo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	
	if (focused) {
	    g2d.setPaint(Color.GREEN);
	    g2d.draw(new RoundRectangle2D.Double(this.x-3, this.y-3, this.w+6, this.h+6, this.arcW, this.arcH));
	}
	
	g2d.setColor(new Color(this.cfr,this.cfg,this.cfb));
	g2d.fill(new RoundRectangle2D.Double(this.x, this.y, this.w, this.h, this.arcW, this.arcH));
  g2d.setColor(new Color(this.ccr,this.ccg,this.ccb));
  g2d.draw(new RoundRectangle2D.Double(this.x, this.y, this.w, this.h, this.arcW, this.arcH));
    }
}
