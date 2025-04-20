public class ClienteEspecial extends Cliente {
    public ClienteEspecial(String nome, double saldo, double limite) {
        super(nome, saldo, limite+1000);
        System.out.println("Cliente especial adicionado à tabela. Limite aumentado em 1000");
    }
    @Override
    public String toString() {
        return "Cliente especial: " + super.toString();
    }
}
