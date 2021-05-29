package figures;

import java.awt.*;

public class Rect extends Figure {

    public Rect (int x, int y, int w, int h, int cfr, int cfg, int cfb, int ccr, int ccg, int ccb) {
        super(x, y, w, h, cfr, cfg, cfb, ccr, ccg, ccb);
    }

    private void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
		
	if (focused) {
	    g2d.setPaint(Color.BLUE);
	    g2d.drawRect(this.x-3, this.y-3, this.w+6, this.h+6);
	}
		
	g2d.setColor(new Color(this.cfr,this.cfg,this.cfb));
	g2d.fillRect(this.x, this.y, this.w, this.h);
    g2d.setColor(new Color(this.ccr,this.ccg,this.ccb));
    g2d.drawRect(this.x, this.y, this.w, this.h);
    }
}
