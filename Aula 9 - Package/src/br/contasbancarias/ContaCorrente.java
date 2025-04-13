package br.contasbancarias;

public class ContaCorrente {
    private String nome;
    private double saldo;
    private static int quantidadeContas;
    public ContaCorrente(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
        ++quantidadeContas;
    }
    public String getNome() {
        return nome;
    }
    public void depositar(double quantia) {
        if(quantia<0) {
            System.out.println("Quantia invalida!");
            return;
        }
        this.saldo+= quantia;
        System.out.println("Depósito realizado. Novo saldo: " + saldo);
    }
    public void sacar(double quantia) {
        if(quantia > saldo) {
            System.out.println("Saldo indisponível!");
            return;
        }
        this.saldo-=quantia;
        this.saldo = desconto(this.saldo);
        System.out.println("Saque realizado com sucesso!");
        System.out.println("Uma taxa de " + desconto(this.saldo) + " foi aplicada!" );
    }
    public double obterSaldo() {
        return this.saldo;
    }
    public double desconto(double saldo) {
        return saldo * 0.02;
    }
    public static int getQuantidadeContas() {
        return quantidadeContas;
    }
}
