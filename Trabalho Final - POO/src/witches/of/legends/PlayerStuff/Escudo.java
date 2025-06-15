package witches.of.legends.PlayerStuff;

public class Escudo {
    private String nome;
    private int defense;
    public Escudo(String nome, int defense) {
        this.nome = nome;
        this.defense = defense;
    }
    public int getDefense() {
        return defense;
    }
    public String getNome() {
        return nome;
    }
}
