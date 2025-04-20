public class Circulo extends Figura{
    private double raio;
    public Circulo(double area, double raio) {
        super(area);
        this.raio = raio;
    }
    @Override
    public double getArea() {
        return area * raio * 3.1412;
    }
}
