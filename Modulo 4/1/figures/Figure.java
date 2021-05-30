package figures;


import ivisible.IVisible;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable {
    public int x, y;
    public int w, h;
    public int cfr,cfg,cfb;
    public int ccr,ccg,ccb;
	
public Figure (int x, int y, int w, int h,int cfr, int cfg, int cfb,int ccr, int ccg, int ccb){
    this.x = x;
    this.y = y;
	this.w = w;
	this.h = h;
    this.cfr = cfr;
    this.cfg = cfg;
	this.cfb = cfb;
    this.ccr = ccr;
    this.ccg = ccg;
	this.ccb = ccb;
 }
	
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public void resize (int dw, int dh) {
	    this.w += dw;
	    this.h += dh;
    }
	
    public void fundo (int cfr, int cfg, int cfb) {
	    this.cfr = cfr;
	    this.cfg = cfg;
	    this.cfb = cfb;
    }

    public void contorno (int ccr, int ccg, int ccb) {
        this.ccr = ccr;
        this.ccg = ccg;
        this.ccb = ccb;
        }

	
    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
}
