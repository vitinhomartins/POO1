package br.contasbancarias;

public class ClienteEspecial extends ContaCorrente{
    public ClienteEspecial(String nome, double saldo) {
        super(nome, saldo);
    }

    @Override
    public double desconto(double saldo) {
        return saldo * 0.01;
    }
}
