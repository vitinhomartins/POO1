public class Shapes {
    public static void main(String[] args) {
        Triangulo t1 = new Triangulo();
        Triangulo t2 = new Triangulo();
        Retangulo r1 = new Retangulo(); // criação do retângulo.
        r1.setAltura(5);
        r1.setLargura(5);
        t1.setLargura(4.0);
        t1.setAltura(4.0);
        t1.setEstilo("cheio");
        t2.setLargura(8.0);
        t2.setAltura(12.0);
        t2.setEstilo("contorno");
        System.out.println("Info para t1: ");
        t1.mostraEstilo();
        t1.mostraDim();
        System.out.println("Area = " + t1.area());
        System.out.println();
        System.out.println("Info para t2: ");
        t2.mostraEstilo();
        t2.mostraDim();
        System.out.println("Area = " + t2.area());
        System.out.println("Retangulo:");
        if (r1.isQuadrado() == true) {
            System.out.println("O retângulo é quadrado!");
        } else {
            System.out.println("O retângulo não é quadrado");
        }
        System.out.println("Area do retângulo: " + r1.Area());
    }
}