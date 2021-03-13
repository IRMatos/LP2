public class PoligonoApp {
    public static void main (String[] args) {
        Poligono p1= new Poligono(50,50,5,100,100);
        p1.print();       
    }
}

class Poligono{
    int x,y,lados,alt,larg;

    Poligono (int x, int y, int lados, int alt,int larg){
        this.x = x ;
        this.y = y;
        this.lados = lados;
        this.alt = alt;
        this.larg = larg;
    }
    void print(){
        System.out.format (" Poligono de %d lados, tamanho (%d,%d) e posicao (%d,%d).\n ", this.lados, this.alt,this.larg,this.x,this.y);
    }
}
