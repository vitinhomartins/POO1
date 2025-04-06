import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int vetor[] = {12, 11, 10, 8, 4, 3, 1};;
        int aux = 0, pos = 0, x = 0, maior = 0, menor = 0;
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        for(int i = 0; i < vetor.length - 1; i++){
            if((vetor[i] - vetor[i+1]) >= aux) {
                aux = vetor[i] - vetor[i+1];
                pos = i;
            }
        }
        for(int i = 0; i < vetor.length; i++) {
            if(x > vetor[i]) {
                menor++;
            } else if (x < vetor[i]){
                maior++;
            }
        }
        System.out.println("A maior queda é entre as posições: " + pos + " e " + ++pos);
        System.out.println("Existem " + maior + " números maiores que " + x);
        System.out.println("Existem " + menor + " números menores que " + x);
    }
}
