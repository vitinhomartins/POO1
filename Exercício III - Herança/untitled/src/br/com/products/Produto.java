package br.com.products;

public class Produto {
    protected String nome;
    protected double preco;
    private static int qntd;
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        ++qntd;
    }
    public boolean ehCaro() {
        if(preco > 80) return true;
        return false;
    }
    public static int getQntd() {
        return qntd;
    }
    public void showProduct() {
        System.out.println(nome);
        System.out.println(preco);
    }
}
