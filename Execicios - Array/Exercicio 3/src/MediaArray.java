import java.util.Scanner;

public class MediaArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] array1 = new double[5];
        double media = 0;
        for(int i = 0; i < 5; i++) {
            array1[i] = scan.nextDouble();
        }
        for(double i : array1) {
            media+=i;
        }
        media = media / array1.length;
        System.out.println(media);
    }
}
