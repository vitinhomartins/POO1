public class TesteDoisGen {
    public static void main(String[] args) {
        DoisGen<Integer, String> ob1 = new DoisGen<>(123, "Ola, mundo!");
        System.out.println("Valor de ob1: " + ob1.getOb1());
        System.out.println("Valor de ob1: " + ob1.getOb2());
        ob1.showType();
    }
}
