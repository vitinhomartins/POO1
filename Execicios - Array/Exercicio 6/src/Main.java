public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {2, 4, 6, 8, 10, 12};
        System.out.println(soma(array1));
        System.out.println(soma(array2));
    }
    public static int soma(int[] args) {
        int soma = 0;
        for(int i : args) {
            soma+=i;
        }
        return soma;
    }
}
