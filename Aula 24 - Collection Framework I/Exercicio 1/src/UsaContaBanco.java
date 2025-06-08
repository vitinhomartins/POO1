import java.util.ArrayList;

public class UsaContaBanco {
    public static void main(String[] args) {
        // Criando o ArrayList de contas
        ArrayList<ContaBanco> contas = new ArrayList<>();

        // Adicionando contas
        contas.add(new ContaBanco(1, 10000));
        contas.add(new ContaBanco(2, 11000));
        contas.add(new ContaBanco(3, 12000));

        // Exibindo total de contas
        System.out.println("Total de contas adicionadas: " + contas.size());

        // Exibindo informações das contas
        System.out.println("\n--- Contas Cadastradas ---");
        for (ContaBanco conta : contas) {
            System.out.printf("Número da conta: %03d – Saldo: R$ %.2f%n", conta.getNumConta(), conta.getSaldo());
        }

        // Realizando depósitos
        contas.get(0).deposito(1200);
        contas.get(1).deposito(1200);
        contas.get(2).deposito(1200);

        // Exibindo contas após depósitos
        System.out.println("\n--- Contas Após Depósitos ---");
        for (ContaBanco conta : contas) {
            System.out.printf("Número da conta: %03d – Saldo: R$ %.2f%n", conta.getNumConta(), conta.getSaldo());
        }

        // Removendo a segunda conta (índice 1)
        contas.remove(1);

        // Exibindo total e contas após remoção
        System.out.println("\nApós remoção de uma conta:");
        System.out.println("Total de contas: " + contas.size());

        System.out.println("\n--- Contas Restantes ---");
        for (ContaBanco conta : contas) {
            System.out.printf("Número da conta: %03d – Saldo: R$ %.2f%n", conta.getNumConta(), conta.getSaldo());
        }
    }
}
