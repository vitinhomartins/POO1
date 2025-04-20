public class TesteFigura {
    public static void main(String[] args) {
        Figura figs[] = new Figura[3];
        figs[0] = new Figura(300);
        figs[1] = new Quadrado(4);
        figs[2] = new Circulo(3, 4);
        // teste das figuras.

        for(int i = 0; i < 3; i++) {
            System.out.println(figs[i].getArea());
        }
    }
}

// O polimorfismo foi usado nos métodos getArea, pois, cada um deveria ter um comportamento diferente.
