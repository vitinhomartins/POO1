package witches.of.legends.PlayerStuff;

import java.util.HashMap;

public class Armas {
    private String nome;
    private int attack;
    private HashMap<Integer, String> ataques;
    public Armas(String nome, int attack, HashMap<Integer, String> ataques) {
        this.nome = nome;
        this.attack = attack;
        this.ataques = ataques;
    }
    public int getAttack() {
        return attack;
    }
    public String getNome() {
        return nome;
    }
    public HashMap<Integer, String> getAtaques() {
        return ataques;
    }

    public void exibirAtaques() {
        System.out.println("Escolha um ataque:");
        for (Integer chave : ataques.keySet()) {
            System.out.println(chave + " - " + ataques.get(chave).split(" - ")[0]);
        }
    }

    public String usarAtaque(int escolha, String nomeBoss) {
        String descricao = ataques.get(escolha);
        if (descricao != null) {
            return descricao.replace("inimigo", nomeBoss);
        } else {
            return "Ataque inválido!";
        }
    }
}
