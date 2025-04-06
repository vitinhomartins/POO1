public class Retangulo extends TwoDShape{
    public double Area() {
        return altura * largura;
    }
    public boolean isQuadrado() {
        if(largura != altura) return false;
        return true;
    }
}
