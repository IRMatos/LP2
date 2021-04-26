package figures;

import java.awt.*;

public class Rect extends Figure {

    public Rect (int x, int y, int w, int h, Color cordefundo, Color contorno) {
        super(x, y, w, h, cordefundo, contorno);
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    @Override

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(this.cordefundo);
        g2d.fillRect(this.x, this.y, this.w, this.h);

        g2d.setColor(this.contorno);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }

    public void redFocus (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1));

        g2d.setColor(Color.yellow);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }
}
