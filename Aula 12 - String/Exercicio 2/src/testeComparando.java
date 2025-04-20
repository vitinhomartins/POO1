public class testeComparando {
    public static void main(String[] args) {
        String[] strings = new String[2];
        strings[0] = "Sol";
        strings[1] = "SOL";
        CompararArgumentos.main(strings);
        strings[0] = "Lua";
        strings[1] = "Mundo";
        CompararArgumentos.main(strings);
    }
}
