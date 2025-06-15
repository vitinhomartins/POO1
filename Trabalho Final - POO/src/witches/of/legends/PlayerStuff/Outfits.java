package witches.of.legends.PlayerStuff;

public class Outfits {
    private String nome;
    private int attack;
    private int defense;
    public Outfits(String nome, int attack, int defense) {
        this.attack = attack;
        this.nome = nome;
        this.defense = defense;
    }
    public int getAttack() {
        return attack;
    }
    public String getNome() {
        return nome;
    }
    public int getDefense() {
        return defense;
    }
}
