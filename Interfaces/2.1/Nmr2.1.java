import java.lang.Math.
  
public interface figuraCalculavel{
    public int area();
    public int perimetro();
}

public class Triangle implements figuraCalculavel{
    public int h;
    public int base;
    public int x, y, z;

    public int h(){
        return h;
    }

    public void setH(int h){
        this.h = h;
    }

    public int base(){
        return base;
    }

    public int setB(int base){
        this.base = base;
    }

    public int ladoX(){
        return x();
    }

    public int ladoY(){
        return y();
    }

    public int ladoZ(){
        return z();
    }

    public void setX(){
        this.x = x;
    }

    public void setY(){
        this.y = y;
    }

    public void setZ(){
        this.z = z;
    }

    @Override
    public int area(){
        int area = 0;
        area = (base * h) / 2;
        return area;
    }

    @Override
    public int perimetro(){
        int perimetro = 0;
        perimetro = x + y + z;
        return perimetro;
    }

    public class Rect implements figuraCalculavel{
        public int x, y, w, h;

        public Rect (int base, int h) {
            this.base = base;
            this.h = h;
        }

        @Override
        public int area(){
            int area = 0;
            area = (base * h);
            return area;
        }
        public int perimetro(){
            int perimetro = 0;
            perimetro = ((2 * base) + (2 * h));
            return perimetro;
        }

    }

    public class Circulo implements figuraCalculavel{
        public double raio;

        public Circulo (double raio){
            this.raio = raio;
        }
        @Override
        public int area(){
            int area = 0;
            area = Math.PI * raio * raio;
        }
        public int perimetro(){
            int perimetro = 0;
            perimetro = 2 * Math.PI * raio;
            return perimetro;
        }
      
      ///////////////////////////////////////////////////////////////////////////////////////

public interface Veiculo {

    public String getNome();
    public String getId();
}
public interface Motor {

    public String getModelo();
    public String getFabricante();
}
      
public class Carro implements Veiculo,Motor{

    @Override
    public String getId() {

   }

    @Override
    public String getNome() {

    }

    @Override
    public String getFabricante() {

    }

    @Override
    public String getModelo() {

    }

  }
}
  
