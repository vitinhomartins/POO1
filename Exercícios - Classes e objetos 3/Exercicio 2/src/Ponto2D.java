public class Ponto2D {
    private double x, y;
    private static int quantidade;
    public Ponto2D() {
        ++quantidade;
        x = 0;
        y = 0;
    }
    public Ponto2D(double x, double y) {
        ++quantidade;
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public static int getQuantidade() {
        return quantidade;
    }
}
