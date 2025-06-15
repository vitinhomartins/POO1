package witches.of.legends.PlayerStuff;

import java.util.ArrayList;

public class Equipamento {
    private ArrayList<Armas> arma = new ArrayList<>();
    private ArrayList<Escudo> escudos = new ArrayList<>();
    private ArrayList<Outfits> roupas = new ArrayList<>();

    public Equipamento(Outfits outfit, Armas arma, Escudo escudo) {
        this.roupas.add(outfit);
        this.arma.add(arma);
        this.escudos.add(escudo);
    }
    public ArrayList<Armas> getArmas() {
        return arma;
    }

    public ArrayList<Escudo> getEscudos() {
        return escudos;
    }

    public ArrayList<Outfits> getRoupas() {
        return roupas;
    }
    public void setEscudo(Escudo escudo) {
        this.escudos.add(escudo);
    }
    public void setArma(Armas arma) {
        this.arma.add(arma);
    }

    public void setRoupas(Outfits roupa) {
        this.roupas.add(roupa);
    }
    public void listarEquipamentos() {
        System.out.println("=== witches.of.legends.PlayerStuff.Armas ===");
        for (int i = 0; i < arma.size(); i++) {
            Armas a = arma.get(i);
            System.out.println(i + " " + a.getNome() + " (attack: " + a.getAttack() + ")");
        }
        System.out.println();
        System.out.println("=== Escudos ===");
        for (int i = 0; i < escudos.size(); i++) {
            Escudo e = escudos.get(i);
            System.out.println(i + " " + e.getNome() + " (defense: " + e.getDefense() + ")");
        }
        System.out.println();
        System.out.println("=== Roupas ===");
        for (int i = 0; i < roupas.size(); i++) {
            Outfits r = roupas.get(i);
            System.out.println(i + " " + r.getNome() + " (attack: " + r.getAttack() + " | defense: " + r.getDefense() + ")");
        }
    }
}
