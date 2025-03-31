public class Retangulo {
    private double comprimento, altura;
    public Retangulo() {
        comprimento=altura=1;
    }
    public Retangulo(double comprimento, double altura) {
        this.comprimento = comprimento;
        this.altura=altura;
    }
    public void modificaRetangulo(double comprimento, double altura) {
        this.comprimento = comprimento;
        this.altura = altura;
    }
    public double Perimetro() {
        return (2 *(altura) + (2*(comprimento)));
    }
    public void exibaPerimetro() {
        System.out.println("Perimetro: "+ (2 *(altura) + (2*(comprimento))));
    }
    public double Area() {
        return altura * comprimento;
    }
    public void exibaArea() {
        System.out.println("Area: " + altura * comprimento);
    }
    public void isQuadrado() {
        if(!(altura == comprimento)) {
            System.out.println("Não eh quadrado");
        } else {
            System.out.println("Eh quadrado");
        }
    }
}
