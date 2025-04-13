package br.com.products;

public class ProdutoApp {
    public static void main(String[] args) {
        Produto p = new Produto("Chapinha de cabelo", 120);
        Livro l = new Livro("Memórias Póstrumas de Brás Cubas", 40, "Machado de Assís", 368);
        if(p.ehCaro()) {
            System.out.println("Produto caro!");
        } else {
            System.out.println("Produto barato");
        }
        p.showProduct();

        if(l.ehExtenso()) {
            System.out.println("É extenso");
        } else {
            System.out.println("É curto");
        }
        if(l.ehCaro()) {
            System.out.println("É caro. Acima de 50 reais");
        } else {
            System.out.println("É barato!");
        }
        l.showProduct();
    }
}
