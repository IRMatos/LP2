package figures;

import java.awt.*;

public abstract class Figure {
    public int x, y, w, h ; 
    public Color cordefundo,contorno;

    public Figure (int x, int y,int w, int h, Color cordefundo, Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.cordefundo = cordefundo;
    }

    public abstract void paint (Graphics g);

    public void drag (int dx, int dy){
        x += dx - x;
        y += dy -y;
    }

}
