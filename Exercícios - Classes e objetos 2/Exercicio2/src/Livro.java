public class Livro {
    private String titulo, autor;

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void exibaInfo() {
        System.out.println("Livro: " + titulo + " " + autor);
    }
}
