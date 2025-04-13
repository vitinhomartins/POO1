package br.contasbancarias;

public class ContasApp {
    public static void main(String[] args) {
        ContaCorrente c[] = new ContaCorrente[3];
        c[0] = new ContaCorrente("Victor Hugo", 1200);
        c[1] = new ContaCorrente("Manuela Pereira", 1500);
        c[2] = new ClienteEspecial("Isabella Martins", 1800);

        // Executar depósito de 120 reais em todas as contas.

        c[0].depositar(120);
        c[1].depositar(120);
        c[2].depositar(120);

        System.out.println("Saldo da conta 1: " + c[0].obterSaldo());
        System.out.println("Saldo da conta 2: " + c[1].obterSaldo());
        System.out.println("Saldo da conta 1: " + c[2].obterSaldo());

        // executar saque de 1200 reais!

        c[0].sacar(1200);
        c[1].sacar(1200);
        c[2].sacar(1200);

        System.out.println("Saldo da conta 1: " + c[0].obterSaldo());
        System.out.println("Saldo da conta 2: " + c[1].obterSaldo());
        System.out.println("Saldo da conta 1: " + c[2].obterSaldo());

        // Quantas contas existem!
        System.out.println("Existem " + ContaCorrente.getQuantidadeContas() + " criadas no sistema");

        // Imprimindo todas as contas!!

        for(ContaCorrente conta : c) {
            System.out.println("Conta pertencente a: " + conta.getNome());
            System.out.println("Saldo: " + conta.obterSaldo());
        }

    }
}
