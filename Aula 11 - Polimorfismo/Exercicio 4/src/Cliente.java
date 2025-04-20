public class Cliente {
    private String nome;
    private double saldo;
    private double limite;
    public Cliente(String nome, double saldo, double limite) {
        this.nome = nome;
        this.limite = limite;
        this.saldo = saldo;
    }
    @Override
    public String toString() {
        return nome + ", saldo: " + saldo + ", limite: " + limite;
    }
}
