package witches.of.legends.PlayerStuff;

public abstract class Personagem {
    private String nome;
    private int attack;
    private int defense;
    private double health;
    private Elementos tipoElemental;
    private Equipamento equipamento;
    Armas armaAtual = null;
    Escudo escudoAtual = null;
    Outfits roupaAtual = null;

    public Personagem(String nome, double health, int attack, int defense, Elementos tipoElemental, Equipamento equipamento) {
        this.nome = nome;
        this.attack = attack;
        this.defense = defense;
        this.equipamento = equipamento;
        this.tipoElemental = tipoElemental;
        this.health = health;

        if (!equipamento.getArmas().isEmpty()) {
            this.armaAtual = equipamento.getArmas().get(0);
        }
        if (!equipamento.getEscudos().isEmpty()) {
            this.escudoAtual = equipamento.getEscudos().get(0);
        }
        if (!equipamento.getRoupas().isEmpty()) {
            this.roupaAtual = equipamento.getRoupas().get(0);
        }
    }
    public String getNome() {
        return nome;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack+= attack;
    }

    public void setDefense(int defense) {
        this.defense+= defense;
    }

    public int getAttack() {
        int total = attack;
        if (armaAtual != null) total += armaAtual.getAttack();
        if (roupaAtual != null) total += roupaAtual.getAttack();
        return total;
    }
    public int getDefense() {
        int total = defense;
        if (escudoAtual != null) total += escudoAtual.getDefense();
        if (roupaAtual != null) total += roupaAtual.getDefense();
        return total;
    }
    public Elementos getTipoElemental() {
        return tipoElemental;
    }
    public void setTipoElemental(Elementos tipoElemental) {
        this.tipoElemental = tipoElemental;
    }

    public double getHealth() {
        return health;
    }
    public void setArmaAtual(Armas armaAtual) {
        this.armaAtual = armaAtual;
    }
    public void setEscudoAtual(Escudo escudoAtual) {
        this.escudoAtual = escudoAtual;
    }
    public void setRoupaAtual(Outfits roupaAtual) {
        this.roupaAtual = roupaAtual;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void receberDano(double dano) {
        this.health -= dano;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
