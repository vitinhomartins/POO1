import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][]matriz = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz.length; j++) {
                matriz[i][j] = scan.nextInt();
            }
        }
        for(int i = 0; i < matriz.length; i++) {
            System.out.println();
            for(int j = 0; j < matriz.length; j++) {
                System.out.println(" "+matriz[i][j]);
            }
        }
    }
}
