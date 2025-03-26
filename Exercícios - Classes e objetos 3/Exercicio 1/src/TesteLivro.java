public class TesteLivro {
    public static void main(String[] args) {
        Livro livro1 = new Livro();
        Livro livro2 = new Livro("Raul Pompeia", "O Ateneu");
        livro1.Exiba();
        livro2.Exiba();
        System.out.println(Livro.getQuantidade());
    }
}
