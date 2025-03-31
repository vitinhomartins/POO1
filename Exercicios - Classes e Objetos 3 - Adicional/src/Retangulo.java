public class Retangulo {
    private double comprimento, altura;
    private static int qntd;
    public Retangulo() {
        comprimento=altura=1;
        ++qntd;
    }
    public Retangulo(double comprimento, double altura) {
        this.comprimento = comprimento;
        this.altura=altura;
        ++qntd;
    }
    public void modificaRetangulo(double comprimento, double altura) {
        if(comprimento <= 0 || altura <=0) {
            System.out.println("Dimensões invalidas");
        } else {
            this.comprimento = comprimento;
            this.altura = altura;
        }
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
    public static void quantidade(){
        System.out.println("Objetos criados:" + qntd);
    }
}
