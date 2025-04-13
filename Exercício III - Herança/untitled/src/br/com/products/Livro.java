package br.com.products;

public class Livro extends Produto {
    private String autor;
    private int paginas;

    public Livro(String nome, double preco, String autor, int paginas) {
        super(nome, preco);
        this.autor = autor;
        this.paginas = paginas;
    }
    public boolean ehExtenso() {
        if(paginas > 300) return true;
        return false;
    }

    @Override
    public boolean ehCaro() {
        if(preco > 50) return true;
        return false;
    }
    @Override
    public void showProduct() {
        System.out.println("Livro: " + nome + " autor: " + autor);
        System.out.println("Número de páginas: " + paginas);
        System.out.println("Preço: " + preco);
    }
}
