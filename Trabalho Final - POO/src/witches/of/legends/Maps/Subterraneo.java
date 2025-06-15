package witches.of.legends.Maps;

import witches.of.legends.PlayerStuff.*;
import witches.of.legends.Run.LegendsOfWitches;
import witches.of.legends.Utilities.ChamberAlreadyCompletedException;
import witches.of.legends.Utilities.Utilities;

import java.util.HashMap;

public class Subterraneo extends Map{
    public static Boss boss;
    public boolean[] chambers = new boolean[3];
    public Subterraneo(int number) {
        super(number);
    }
    @Override
    String getNome() {
        return "Subterraneo Eterno";
    }

    @Override
    void iniciarMapa() {
        Utilities.limparChat(2);
        System.out.println(LegendsOfWitches.playerGlobal.getNome()+ "- O cheiro está ficando mais forte aqui no subterraneo! Weh");
    }
    @Override
    public void entrarChamber(int numero) throws ChamberAlreadyCompletedException {
        if (numero < 1 || numero > 5) {
            throw new IllegalArgumentException("Número de câmara inválido! Deve ser entre 1 e 5.");
        }
        if (chambers[numero]) {
            throw new ChamberAlreadyCompletedException(numero);
        }
        switch(numero) {
            case 1:
                Utilities.limparChat(2);
                System.out.println("Você acaba de entrar na câmara 2.\nVyreel, o Sussurro das Sombras.\nVyreel - Silêncio... nas sombras, é onde sua luz se apaga.");
                HashMap<Integer, String> ataquesVyreel = new HashMap<>();
                ataquesVyreel.put(1, "Garras Sombras - Um ataque súbito com garras envoltas em escuridão pura!");
                ataquesVyreel.put(2, "Névoa Ilusória - Vyreel se desfaz em sombras, confundindo e ferindo o inimigo!");
                ataquesVyreel.put(3, "Grito do Abismo - Um rugido sombrio que enfraquece a defesa inimiga!");
                Armas armaVyreel = new Armas("Garras de Trevas", 28, ataquesVyreel);
                Escudo escudoVyreel = new Escudo("Escudo das Almas Penadas", 12);
                Outfits armaduraVyreel = new Outfits("Manto do Crepúsculo", 18, 8);
                Equipamento equipamentoVyreel = new Equipamento(armaduraVyreel, armaVyreel, escudoVyreel);
                boss = new Boss("Vyreel", 210, 60, 30, Elementos.SHADOWS, equipamentoVyreel);
                break;
            case 2:
                Utilities.limparChat(2);
                System.out.println("Você acaba de entrar na câmara 3.\nZephrya, a Rainha dos Céus.\nZephrya - Tolo. A tempestade não perdoa os fracos!");

                HashMap<Integer, String> ataquesZephrya = new HashMap<>();
                ataquesZephrya.put(1, "Lâmina do Vendaval - Um corte rápido impulsionado por ventos cortantes!");
                ataquesZephrya.put(2, "Tornado Ascendente - Zephrya levanta um ciclone que lança o inimigo ao ar!");
                ataquesZephrya.put(3, "Rajada Sônica - Um disparo de vento tão rápido que estilhaça a armadura!");

                Armas armaZephrya = new Armas("Espada dos Céus", 45, ataquesZephrya);
                Escudo escudoZephrya = new Escudo("Barreira Aérea", 14);
                Outfits armaduraZephrya = new Outfits("Véu Celestial", 12, 12);

                Equipamento equipamentoZephrya = new Equipamento(armaduraZephrya, armaZephrya, escudoZephrya);
                boss = new Boss("Zephrya", 200, 60, 30, Elementos.AIR, equipamentoZephrya);
                break;
        }
    }
    @Override
    public void enfrentarBossFinal() {
        Utilities.limparChat(2);
        System.out.println("O ar fica pesado... Uma presença sombria domina a sala.");
        System.out.println("Das sombras, uma figura imponente surge: é Isabella, a Mãe Sombria.");
        System.out.println("Isabella: \"Meu filho... até aqui você veio? Então prove que está pronto para carregar o legado... ou pereça sob meu poder.\"");

        HashMap<Integer, String> ataquesIsabella = new HashMap<>();
        ataquesIsabella.put(1, "Toque do Vazio - Uma energia sombria drena a vida do inimigo lentamente.");
        ataquesIsabella.put(2, "Correntes Abissais - Correntes negras emergem do chão e aprisionam o inimigo, causando dor contínua.");
        ataquesIsabella.put(3, "Ruptura Sombria - Isabella explode em escuridão pura, atingindo tudo ao redor com fúria ancestral.");

        Armas armaIsabella = new Armas("Cajado da Eternidade Sombria", 50, ataquesIsabella); // Arma mais forte do jogo
        Escudo escudoIsabella = new Escudo("Véu das Almas Antigas", 25);
        Outfits roupaIsabella = new Outfits("Túnica do Eclipse", 30, 25);

        Equipamento equipamentoIsabella = new Equipamento(roupaIsabella, armaIsabella, escudoIsabella);
        Boss isabella = new Boss("Isabella", 400, 35, 30, Elementos.SHADOWS, equipamentoIsabella);


        // Assumindo que você esteja chamando do main e tenha o player lá
        boolean ganhou = LegendsOfWitches.fighting(LegendsOfWitches.playerGlobal, isabella);
        while(!ganhou){
            if(LegendsOfWitches.playerGlobal.getHealth()<0) {
                System.out.println("Você foi derrotado, mas ainda pode tentar novamente.");
                LegendsOfWitches.playerGlobal.setHealth(160);
                System.out.println("Sua vida foi restaurada!");
                Utilities.limparChat(2);
                System.out.println("Mude seus equipamentos para tentar melhor!");
                LegendsOfWitches.playerGlobal.trocarEquipamento();
                ganhou = LegendsOfWitches.fighting(LegendsOfWitches.playerGlobal, isabella);
            }
        }
        Utilities.limparChat(2);
        System.out.println(LegendsOfWitches.playerGlobal.getNome() + " - Eu me corrompi! Agora entendo tudo o que houve.\nMinha mãe não tinha culpa de nada, eu sou o Deus do caos!");
        Utilities.limparChat(2);
    }

    @Override
    void resetarMapa() {

    }
}
