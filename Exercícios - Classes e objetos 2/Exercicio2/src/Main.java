public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro();
        livro1.setAutor("Raul Pompeia");
        livro1.setTitulo("O Ateneu");
        Livro livro2 = new Livro();
        livro2.setAutor("Machado de Assis");
        livro2.setTitulo("Memorias postrumas de bras cubas");

        livro1.exibaInfo();
        livro2.exibaInfo();



    }
}
