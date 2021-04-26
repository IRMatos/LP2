package figures;

import java.awt.*;

public class Triangulo extends Figure {
    Polygon Triangulo;

    public Triangulo (int x, int y,int w, int h, Color cordefundo, Color contorno) {
        super(x, y, h, w, cordefundo, contorno);
    }
    

    public void print () {
        System.out.printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int[] yt = new int[]{y, y + h, y + h}; 
        int[] xt = new int[]{x + w/2, x + w, x};

        Polygon TrianguloObject = new Polygon(yt, xt, 3);

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(this.cordefundo);
        g2d.fillPolygon(TrianguloObject);

        g2d.setColor(this.contorno);
        g2d.drawPolygon(TrianguloObject);
    }
}
