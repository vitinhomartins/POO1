public class TestePonto2D {
    public static void main(String[] args) {
        Ponto2D p1 = new Ponto2D(1, 2);
        Ponto2D p2 = new Ponto2D();
        System.out.println("Coordenadas de P1:");
        System.out.printf("%.2f ", p1.getX() );
        System.out.printf("%.2f ", p1.getY());
        System.out.println("Coordenadas de P2:");
        System.out.printf("%.2f ", p2.getX() );
        System.out.printf("%.2f ", p2.getY() );
        System.out.println("Quantidade de pontos: "+Ponto2D.getQuantidade());
    }
}
