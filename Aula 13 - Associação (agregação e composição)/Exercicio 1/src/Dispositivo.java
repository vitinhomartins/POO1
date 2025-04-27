public class Dispositivo {
    private int codigo;
    private String nome;
    Dispositivo (int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public void usar(String nome) {
        System.out.println(nome + " está usando o dispositivo: " + this.nome);
    }
}
