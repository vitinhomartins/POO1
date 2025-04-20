public class processaString {
    public static void main(String[] args) {
        String nome = "Vitinho";
        System.out.println(processa(nome));
    }
    public static String processa(String processar) {
        if(processar == null) return null;
        return processar.toUpperCase();
    }
}
