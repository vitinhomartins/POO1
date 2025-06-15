package witches.of.legends.Maps;

import witches.of.legends.PlayerStuff.Boss;

public abstract class Chambers {
    private String nome;
    private Boss boss;
    public Chambers(String nome, Boss boss) {
        this.nome = nome;
        this.boss = boss;
    }
    abstract void getNome();
    abstract Boss getBoss();
}
