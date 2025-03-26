public class Livro {
    private String autor, titulo;
    private static int quantidade;
    public Livro() {
        ++quantidade;
        this.autor = "Anonimo";
        this.titulo = "Desconhecido";
    }
    public Livro(String autor, String titulo) {
        ++quantidade;
        this.titulo = titulo;
        this.autor = autor;
    }
    public static int getQuantidade() {
        return quantidade;
    }
    public void Exiba() {
        System.out.println(this.autor + " " + this.titulo);
    }
}
