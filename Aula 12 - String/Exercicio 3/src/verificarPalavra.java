public class verificarPalavra {
    public static void main(String[] args) {
        args = new String[1];
        args[0] = "Palavrão";
        verificaPalavra(args[0]);
    }

    public static void verificaPalavra(String palavra) {
        if (palavra.length() < 8) {
            System.out.println("Contém menos que 8 caractéres");
            return;
        }
        palavra = palavra.substring(0, 2) + palavra.substring(palavra.length() - 2);
        System.out.println("Nova palavra formada: " + palavra);
    }
}