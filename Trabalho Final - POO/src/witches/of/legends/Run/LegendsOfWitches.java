package witches.of.legends.Run;


import witches.of.legends.Maps.StartMap;
import witches.of.legends.Maps.Subterraneo;
import witches.of.legends.PlayerStuff.*;
import witches.of.legends.Utilities.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LegendsOfWitches {
    public static Jogador playerGlobal;
    public static BattleLogger logger;
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
        logger = new ArquivosLog(playerGlobal.getNome() + ".txt");
        System.out.println("Seja bem-vindo ao Legends of Witches.\nSua missão é entrar nas minas antigas e\naveriguar o motivo do grande miasma de terror sendo emitido!");
        while (chambersConcluidas < 2) {
            try {
                System.out.println("Escolha uma câmara [1 - 2]: ");
                int escolha = scanner.nextInt();
                mapaInicial.entrarChamber(escolha);

                boolean venceu = LegendsOfWitches.fighting(playerGlobal, StartMap.boss);

                if (StartMap.boss.getHealth() <= 0 && venceu) {
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
    /**
     * Segundo mapa = Subterrâneo.
     * Cada câmara possui um boss e o jogador deve vencê-los para avançar.
     * Caso seja derrotado, sua vida é restaurada e ele pode trocar seus equipamentos.
     * O progresso é salvo e, ao vencer as duas câmaras, o jogador enfrentará o boss final.
     *
     * @author Victor Hugo e Manuela
     * @exception InputMismatchException se a entrada fornecida não for um número inteiro.
     * @exception IllegalArgumentException se o valor escolhido para a câmara for inválido.
     */
    public static void mapa2()  {
        int chambersConcluidas = 0;
        Subterraneo subterraneo = new Subterraneo(1);
        Scanner scanner = new Scanner(System.in);
        while(chambersConcluidas < 2) {
            try {
                System.out.println("Escolha uma câmara [1 - 2]: ");
                int escolha = scanner.nextInt();
                subterraneo.entrarChamber(escolha);

                boolean venceu = LegendsOfWitches.fighting(playerGlobal, Subterraneo.boss);

                if (Subterraneo.boss.getHealth() <= 0 && venceu) {
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

    /**
     * Inicia uma batalha entre um jogador e um boss, turnos alternados de ataque.
     * Exibe mensagens ao jogador e registra todas as ações em um arquivo de log.
     * O jogador pode escolher ataques e receber recompensas específicas.
     *
     * @author Victor Hugo e Manuela
     * @param player o {@code Jogador} que enfrentará o boss, contendo status e equipamentos.
     * @param boss o {@code Boss} inimigo que lutará contra o jogador, também com status e equipamentos.
     * @return true se o jogador vencer o boss, false se for derrotado.
     */

    public static boolean fighting(Jogador player, Boss boss) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nBatalha iniciada contra " + boss.getNome() + "!");
        logger.log("\nBatalha iniciada contra " + boss.getNome() + "!");
        System.out.println("Vida do boss: " + boss.getHealth() + " Attack do boss: " + boss.getAttack() + " defesa do boss: " + boss.getDefense());
        logger.log("Vida do boss: " + boss.getHealth() + " Attack do boss: " + boss.getAttack() + " defesa do boss: " + boss.getDefense());
        while (player.getHealth() > 0 && boss.getHealth() > 0) {
            Armas armaAtual = player.getArmaAtual();
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
                    scanner.nextLine();
                }
            }

            // Exibir descrição do ataque escolhido
            System.out.println(armaAtual.usarAtaque(escolhaAtaque, boss.getNome()));
            logger.log(armaAtual.usarAtaque(escolhaAtaque, boss.getNome()));
            // --- Jogador ataca ---
            double danoPlayer = Utilities.calcularDano(player, boss);
            boss.receberDano(danoPlayer);
            System.out.println(player.getNome() + " ataca " + boss.getNome() + " causando " + danoPlayer + " de dano!");
            System.out.println(boss.getNome() + " agora tem " + boss.getHealth() + " de vida.");
            logger.log(player.getNome() + " ataca " + boss.getNome() + " causando " + danoPlayer + " de dano!");
            logger.log(boss.getNome() + " agora tem " + boss.getHealth() + " de vida.");
            if (boss.getHealth() <= 0) {
                if (StartMap.boss.getNome().equals("Ignarok")&&StartMap.acontecendo) {
                    System.out.println("Ignarok caiu em combate! Você obtém sua lança lendária!");
                    logger.log("Ignarok caiu em combate! Você obtém sua lança lendária!");
                    Armas armaBoss = boss.getEquipamento().getArmas().getFirst();
                    playerGlobal.getEquipamento().setArma(armaBoss);
                }
                else if (StartMap.boss.getNome().equals("Sylphira")&&StartMap.acontecendo) {
                    System.out.println("Sylphira dissipou-se no vento... Você obtém seu escudo etéreo!");
                    logger.log("Sylphira dissipou-se no vento... Você obtém seu escudo etéreo!");
                    Escudo escudoBoss = boss.getEquipamento().getEscudos().getFirst();
                    playerGlobal.getEquipamento().setEscudo(escudoBoss);
                }
                else if(StartMap.boss.getNome().equals("Camellia") && StartMap.acontecendo) {
                    System.out.println("Parabéns! Você derrotou Camellia.");
                    logger.log("Parabéns! Você derrotou Camellia.");
                    Armas armaBoss = boss.getEquipamento().getArmas().getFirst();
                    playerGlobal.getEquipamento().setArma(armaBoss);
                }
                else if(Subterraneo.boss.getNome().equals("Vyreel") ) {
                    System.out.println("Parabéns! Você derrotou Vyreel.");
                    logger.log("Parabéns! Você derrotou Vyreel.");
                    Outfits outfitBoss = boss.getEquipamento().getRoupas().getFirst();
                    playerGlobal.getEquipamento().setRoupas(outfitBoss);
                }
                else if(Subterraneo.boss.getNome().equals("Zephrya")){
                    System.out.println("Parabéns! Você derrotou Zephrya.");
                    logger.log("Parabéns! Você derrotou Zephrya.");
                    Armas armaBoss = boss.getEquipamento().getArmas().getFirst();
                    playerGlobal.getEquipamento().setArma(armaBoss);
                }else if(Subterraneo.boss.getNome().equals("Isabella")) {
                    System.out.println("Parabéns! Você derrotou Isabella, sua mãe.");
                    logger.log("Parabéns! Você derrotou Isabella, sua mãe.");
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
            logger.log(boss.getNome() + " ataca " + player.getNome() + " causando " + danoBoss + " de dano!");
            logger.log(player.getNome() + " agora tem " + player.getHealth() + " de vida.");
            if (player.getHealth() <= 0) {
                System.out.println(player.getNome() + " foi derrotado por " + boss.getNome() + "...");
                logger.log(player.getNome() + " foi derrotado por " + boss.getNome() + "...");
            }

            System.out.println("\n--- Próxima rodada ---");
            Utilities.pausar(2);
        }
        return false;
    }

}

