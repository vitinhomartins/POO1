public class Quadrado extends Figura{
    public Quadrado(double area) {
        super(area);
    }
    @Override
    public double getArea() {
        return area * area;
    }
}
