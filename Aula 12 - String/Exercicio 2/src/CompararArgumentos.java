public class CompararArgumentos {
    public static void main(String[] args) {
        for(String i : args) {
            System.out.println(i);
        }
        if(args[0].equals(args[1])) {
            System.out.println(args[0] + " e " + args[1] + " são iguais");
        } else {
            System.out.println(args[0] + " e " + args[1] + " não são iguais");
        }
        if(args[0].equalsIgnoreCase(args[1])) {
            System.out.println(args[0] + " e " + args[1] + " são iguais ignorando case");
        } else {
            System.out.println(args[0] + " e " + args[1] + " não são iguais ignorando case");
        }
    }
}
