public class TestaRetangulo {
    public static void main(String[] args) {
        Retangulo ret1 = new Retangulo();
        Retangulo ret2 = new Retangulo(3, 5); // quadrado
        System.out.println("Perimetro ret1: " + ret1.Perimetro());
        System.out.println("Area ret1: " + ret1.Area());
        ret1.exibaPerimetro();
        ret1.exibaArea();
        ret1.isQuadrado();

        System.out.println("Retangulo 2:");

        System.out.println("Perimetro ret2: " + ret2.Perimetro());
        System.out.println("Area ret1: " + ret2.Area());
        ret2.exibaPerimetro();
        ret2.exibaArea();
        ret2.isQuadrado();

    }
}
