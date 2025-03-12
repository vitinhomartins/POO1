// Victor Hugo Martins de Oliveira
public class Exercício1 {
    public static void main(String[] args) {
        System.out.println("Primeiro loop:");
        for(int i = 10; i <= 25; i++) {
            System.out.println(i);
        }
        System.out.println("Segundo loop:");
        int i = 10;
        while(i <= 25) {
            System.out.println(i);
            i++;
        }
        System.out.println("Terceiro loop:");
        i = 10;
        do {
            System.out.println(i);
            i++;
        } while(i <=25);
    }
}