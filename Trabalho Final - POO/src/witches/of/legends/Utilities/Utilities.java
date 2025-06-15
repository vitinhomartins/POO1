package witches.of.legends.Utilities;

import witches.of.legends.PlayerStuff.Boss;
import witches.of.legends.PlayerStuff.Elementos;
import witches.of.legends.PlayerStuff.Jogador;
import witches.of.legends.PlayerStuff.Personagem;

public class Utilities {
    public static void limparChat(int n) {
        for(int i = 0; i < n; i++) {
            System.out.println();
        }
    }
    public static void pausar(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Pausa interrompida.");
            Thread.currentThread().interrupt();
        }
    }
    public static double calcularDano(Personagem atacante, Personagem defensor) {
        int ataque = atacante.getAttack();
        int defesa = defensor.getDefense();


        double danoBase = Math.max(0, ataque - defesa);


        double multiplicador = calcularMultiplicador(atacante.getTipoElemental(), defensor.getTipoElemental());

        return danoBase * multiplicador;
    }
    public static double calcularMultiplicador(Elementos atacante, Elementos defensor) {
        if (atacante == defensor) return 1.0;

        switch (atacante) {
            case WATER:
                switch (defensor) {
                    case FIRE: return 1.5;
                    case EARTH: return 0.75;
                    case SHADOWS: return 1.1;
                    default: return 1.0;
                }

            case FIRE:
                return switch (defensor) {
                    case WATER -> 0.5;
                    case AIR, SHADOWS -> 1.25;
                    case EARTH -> 1.1;
                    default -> 1.0;
                };

            case AIR:
                return switch (defensor) {
                    case EARTH -> 1.3;
                    case FIRE -> 0.9;
                    default -> 1.0;
                };

            case EARTH:
                return switch (defensor) {
                    case WATER -> 1.25;
                    case FIRE -> 0.9;
                    case AIR -> 0.7;
                    case SHADOWS -> 1.1;
                    default -> 1.0;
                };

            case LIGHT:
                return switch (defensor) {
                    case SHADOWS -> 1.6;
                    default -> 1.0;
                };

            case SHADOWS:
                return switch (defensor) {
                    case LIGHT -> 1.6;
                    default -> 1.0;
                };

            default:
                return 1.0;
        }
    }

}
