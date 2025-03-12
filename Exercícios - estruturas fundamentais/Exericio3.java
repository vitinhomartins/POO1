// Victor Hugo Martins de Oliveira
public class Exericio3 {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i+=2) {
            System.out.println(i);
        }
        System.out.println("Segundo exercício");
        int soma = 0;
        for(int i = 0; i <= 100; i++) {
            soma+=i;
            if(soma < 100) {
                System.out.println(i);
            }
        }
    }
}
