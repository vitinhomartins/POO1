public class TwoDShape {
    protected double largura;
    protected double altura;
    public void mostraDim() {
        System.out.println("Largura e altura = " + largura + " e " + altura);
    }
    public double getLargura() {
        return largura;
    }
    public void setLargura(double largura) {
        this.largura = largura;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
}