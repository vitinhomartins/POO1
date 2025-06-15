package witches.of.legends.Run;

import witches.of.legends.Maps.Map;
import witches.of.legends.Maps.StartMap;
import witches.of.legends.Maps.Subterraneo;
import witches.of.legends.PlayerStuff.*;
import witches.of.legends.Utilities.ChamberAlreadyCompletedException;
import witches.of.legends.Utilities.ItemIndexInvalidoException;
import witches.of.legends.Utilities.Utilities;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LegendsOfWitches {
    public static Jogador playerGlobal;
    public static void main(String[] args) {
        // variáveis importates
        int chambersConcluidas = 0;

        StartMap mapaInicial = new StartMap(0);
        mapaInicial.iniciarMapa();
        Utilities.pausar(3);
        Utilities.limparChat(3);
        System.out.println("Digite seu nome para continuar: ");
        Scanner scanner = new Scanner(System.in);
        String nome = null;
        try {
            nome = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Digite um nome válido!");
        }
        HashMap<Integer, String> ataquesEspadaInicial = new HashMap<>();
        ataquesEspadaInicial.put(1, "Corte Rápido - O jogador cortou o ar rapidamente e atingiu o inimigo!");
        ataquesEspadaInicial.put(2, "Estocada Precisa - Uma estocada certeira foi desferida contra o inimigo!");
        ataquesEspadaInicial.put(3, "Golpe Giratório - O jogador girou com força, atingindo o inimigo em cheio!");
        Armas armaPlayer = new Armas("Espada Inicial", 25, ataquesEspadaInicial);
        Escudo escudoPlayer = new Escudo("Escudo inicial", 10);
        Outfits roupaPlayer = new Outfits("Roupa inicial", 15, 8);
        Equipamento equipamentoPlayer = new Equipamento(roupaPlayer, armaPlayer, escudoPlayer);
        playerGlobal = new Jogador(nome, 120, 20, 25, Elementos.LIGHT, equipamentoPlayer);
        System.out.println("Seja bem-vindo ao Legends of Witches.\nSua missão é entrar nas minas antigas e\naveriguar o motivo do grande miasma de terror sendo emitido!");
        while (chambersConcluidas < 2) {
            try {
                System.out.println("Escolha uma câmara [1 - 2]: ");
                int escolha = scanner.nextInt();
                mapaInicial.entrarChamber(escolha);

                boolean venceu = LegendsOfWitches.fighting(playerGlobal, StartMap.boss);

                if (StartMap.boss.getHealth() <= 0) {
                    mapaInicial.chambers[escolha] = true;
                    playerGlobal.setHealth(120);
                    chambersConcluidas++;
                    System.out.println("Você venceu a câmara " + escolha + "! [" + chambersConcluidas + "/2]");
                    Utilities.limparChat(2);
                    playerGlobal.trocarEquipamento();
                } else {
                    System.out.println("Você foi derrotado, mas ainda pode tentar novamente.");
                    playerGlobal.setHealth(120);
                    System.out.println("Sua vida foi restaurada!");
                    Utilities.limparChat(2);
                    System.out.println("Mude seus equipamentos para tentar melhor!");
                    playerGlobal.trocarEquipamento();
                }
            } catch (ChamberAlreadyCompletedException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
            }
        }
        mapaInicial.enfrentarBossFinal();
    }

    public static void mapa2() {
        int chambersConcluidas = 0;
        Subterraneo subterraneo = new Subterraneo(1);
        Scanner scanner = new Scanner(System.in);
        while(chambersConcluidas < 2) {
            try {
                System.out.println("Escolha uma câmara [1 - 2]: ");
                int escolha = scanner.nextInt();
                subterraneo.entrarChamber(escolha);

                boolean venceu = LegendsOfWitches.fighting(playerGlobal, Subterraneo.boss);

                if (Subterraneo.boss.getHealth() <= 0) {
                    subterraneo.chambers[escolha] = true;
                    playerGlobal.setHealth(120);
                    chambersConcluidas++;
                    System.out.println("Você venceu a câmara " + escolha + "! [" + chambersConcluidas + "/2]");
                    Utilities.limparChat(2);
                    playerGlobal.trocarEquipamento();
                } else {
                    System.out.println("Você foi derrotado, mas ainda pode tentar novamente.");
                    playerGlobal.setHealth(120);
                    System.out.println("Sua vida foi restaurada!");
                    Utilities.limparChat(2);
                    System.out.println("Mude seus equipamentos para tentar melhor!");
                    playerGlobal.trocarEquipamento();
                }
            } catch (ChamberAlreadyCompletedException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
            }
        }
        subterraneo.enfrentarBossFinal();
    }

    public static boolean fighting(Jogador player, Boss boss) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nBatalha iniciada contra " + boss.getNome() + "!");
        System.out.println("Vida do boss: " + boss.getHealth() + " Attack do boss: " + boss.getAttack() + " defesa do boss: " + boss.getDefense());

        while (player.getHealth() > 0 && boss.getHealth() > 0) {
            Armas armaAtual = player.getEquipamento().getArmas().getFirst();
            armaAtual.exibirAtaques();

            int escolhaAtaque;
            while (true) {
                try {
                    System.out.print("Escolha seu ataque: ");
                    escolhaAtaque = scanner.nextInt();
                    if (!armaAtual.getAtaques().containsKey(escolhaAtaque)) {
                        System.out.println("Ataque inválido. Tente novamente.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número.");
                    scanner.nextLine(); // limpa o buffer
                }
            }

            // Exibir descrição do ataque escolhido
            System.out.println(armaAtual.usarAtaque(escolhaAtaque, boss.getNome()));

            // --- Jogador ataca ---
            double danoPlayer = Utilities.calcularDano(player, boss);
            boss.receberDano(danoPlayer);
            System.out.println(player.getNome() + " ataca " + boss.getNome() + " causando " + danoPlayer + " de dano!");
            System.out.println(boss.getNome() + " agora tem " + boss.getHealth() + " de vida.");

            if (boss.getHealth() <= 0) {
                if (StartMap.boss.getNome().equals("Ignarok")&&StartMap.acontecendo) {
                    System.out.println("Ignarok caiu em combate! Você obtém sua lança lendária!");
                    Armas armaBoss = boss.getEquipamento().getArmas().getFirst();
                    playerGlobal.getEquipamento().setArma(armaBoss);
                }
                else if (StartMap.boss.getNome().equals("Sylphira")&&StartMap.acontecendo) {
                    System.out.println("Sylphira dissipou-se no vento... Você obtém seu escudo etéreo!");
                    Escudo escudoBoss = boss.getEquipamento().getEscudos().getFirst();
                    playerGlobal.getEquipamento().setEscudo(escudoBoss);
                }
                else if(StartMap.boss.getNome().equals("Camellia") && StartMap.acontecendo) {
                    System.out.println("Parabéns! Você derrotou Camellia.");
                    Armas armaBoss = boss.getEquipamento().getArmas().getFirst();
                    playerGlobal.getEquipamento().setArma(armaBoss);
                }
                else if(Subterraneo.boss.getNome().equals("Vyreel") ) {
                    System.out.println("Parabéns! Você derrotou Vyreel.");
                    Outfits outfitBoss = boss.getEquipamento().getRoupas().getFirst();
                    playerGlobal.getEquipamento().setRoupas(outfitBoss);
                }
                else if(Subterraneo.boss.getNome().equals("Zephrya")){
                    System.out.println("Parabéns! Você derrotou Zephrya.");
                    Armas armaBoss = boss.getEquipamento().getArmas().getFirst();
                    playerGlobal.getEquipamento().setArma(armaBoss);
                }else if(Subterraneo.boss.getNome().equals("Isabella")) {
                    System.out.println("Parabéns! Você derrotou Isabella, sua mãe.");
                    Armas armaBoss = boss.getEquipamento().getArmas().getFirst();
                    playerGlobal.getEquipamento().setArma(armaBoss);
                }
                return true;
            }

            Utilities.pausar(1);

            // --- Boss ataca ---
            double danoBoss = Utilities.calcularDano(boss, player);
            player.receberDano(danoBoss);
            System.out.println(boss.getNome() + " ataca " + player.getNome() + " causando " + danoBoss + " de dano!");
            System.out.println(player.getNome() + " agora tem " + player.getHealth() + " de vida.");

            if (player.getHealth() <= 0) {
                System.out.println(player.getNome() + " foi derrotado por " + boss.getNome() + "...");

            }

            System.out.println("\n--- Próxima rodada ---");
            Utilities.pausar(2);
        }
        return false;
    }

    public static void trocarEquipamentos(Jogador player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- TROCA DE EQUIPAMENTOS ---");

        try {
            // Trocar arma
            System.out.println("\nArmas disponíveis:");
            for (int i = 0; i < player.getEquipamento().getArmas().size(); i++) {
                Armas arma = player.getEquipamento().getArmas().get(i);
                System.out.println("[" + i + "] " + arma.getNome() + " | Dano: " + arma.getAttack());
            }
            System.out.print("Escolha a arma a ser equipada (número): ");
            int escolhaArma = scanner.nextInt();
            if (escolhaArma < 0 || escolhaArma >= player.getEquipamento().getArmas().size()) {
                throw new ItemIndexInvalidoException("Índice de arma inválido.");
            }
            player.getEquipamento().setArma(player.getEquipamento().getArmas().get(escolhaArma));
            System.out.println("Arma equipada com sucesso!");

            // Trocar escudo
            System.out.println("\nEscudos disponíveis:");
            for (int i = 0; i < player.getEquipamento().getEscudos().size(); i++) {
                Escudo escudo = player.getEquipamento().getEscudos().get(i);
                System.out.println("[" + i + "] " + escudo.getNome() + " | Defesa: " + escudo.getDefense());
            }
            System.out.print("Escolha o escudo a ser equipado (número): ");
            int escolhaEscudo = scanner.nextInt();
            if (escolhaEscudo < 0 || escolhaEscudo >= player.getEquipamento().getEscudos().size()) {
                throw new ItemIndexInvalidoException("Índice de escudo inválido.");
            }
            player.getEquipamento().setEscudo(player.getEquipamento().getEscudos().get(escolhaEscudo));
            System.out.println("Escudo equipado com sucesso!");

            // Trocar armadura
            System.out.println("\nRoupas/Armaduras disponíveis:");
            for (int i = 0; i < player.getEquipamento().getRoupas().size(); i++) {
                Outfits roupa = player.getEquipamento().getRoupas().get(i);
                System.out.println("[" + i + "] " + roupa.getNome() + " | Defesa: " + roupa.getDefense());
            }
            System.out.print("Escolha a roupa a ser equipada (número): ");
            int escolhaRoupa = scanner.nextInt();
            if (escolhaRoupa < 0 || escolhaRoupa >= player.getEquipamento().getRoupas().size()) {
                throw new ItemIndexInvalidoException("Índice de roupa inválido.");
            }
            player.getEquipamento().setRoupas(player.getEquipamento().getRoupas().get(escolhaRoupa));
            System.out.println("Roupa equipada com sucesso!");

            System.out.println("\n--- Equipamentos atualizados com sucesso! ---");
        } catch (ItemIndexInvalidoException e) {
            System.out.println("Erro ao trocar equipamento: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.nextLine(); // Limpar o buffer
        }
    }

}

