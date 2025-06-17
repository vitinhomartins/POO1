package witches.of.legends.Maps;


import witches.of.legends.PlayerStuff.*;
import witches.of.legends.Run.LegendsOfWitches;
import witches.of.legends.Utilities.ChamberAlreadyCompletedException;
import witches.of.legends.Utilities.Utilities;

import java.util.HashMap;

/**
 * Classe que representa o primeiro mapa do jogo: Ilha do Sangue Eterno.
 * Define as câmaras, bosses e lógica de entrada em cada local e combate.
 *
 * @author Victor Hugo e Manuela
 */

public class StartMap extends Map{
    public static Boss boss;
    public static boolean acontecendo = true;
    public boolean[] chambers = new boolean[3];
    public StartMap(int numberMap) {
        super(numberMap);
    }
    @Override
    String getNome() {
        return "Ilha do Sangue Eterno";
    }
    @Override
    public void iniciarMapa() {
        System.out.println("Seja bem-vindo(a) à Ilha do Sangue Eterno.");
        System.out.println("Não se sabe ao certo o surgimento dessa ilha. E acredita-se que poucas pessoas de fato conhecem!");
        System.out.println("A sua missão é entrar nas minas desertas. Aparentemente o cheiro de lá está insuportável. Cheira... a medo!");
    }

    public void entrarNasMinas() {
        Utilities.limparChat(3);
        System.out.println("Você adentrou as minas antigas!\nForam encontradas 5 portas");
        System.out.println("Não se sabe o que ao certo será encontrado atrás de cada uma delas.");
    }

    /**
     * Permite que o jogador entre em uma câmara específica, ativando o boss correspondente.
     *
     * @param numero o número da câmara que deseja entrar (1 a 2).
     * @throws ChamberAlreadyCompletedException caso a câmara já tenha sido vencida anteriormente.
     * @throws IllegalArgumentException se o número da câmara for inválido (fora do intervalo 1 a 2).
     */

    @Override
    public void entrarChamber(int numero) throws ChamberAlreadyCompletedException {
        if (numero < 1 || numero > 2) {
            throw new IllegalArgumentException("Número de câmara inválido! Deve ser entre 1 e 5.");
        }
        if (chambers[numero]) {
            throw new ChamberAlreadyCompletedException(numero);
        }
        switch(numero) {
            case 1:
                Utilities.limparChat(2);
                System.out.println("Você acaba de entrar na câmara 1.\nIgnarok, o Leão Flamejante.\nIgnarok - É um prazer conhecê-lo, filho dela. Prepare-se, a luta será dura.");
                HashMap<Integer, String> ataquesIgnarok = new HashMap<>();
                ataquesIgnarok.put(1, "Estocada Flamejante - A lança incendeia e perfura violentamente o inimigo!");
                ataquesIgnarok.put(2, "Chicote de Brasas - Um giro rápido cria um rastro de brasas que atingem o inimigo!");
                ataquesIgnarok.put(3, "Explosão de Fogo - A lança libera uma onda explosiva de calor contra o inimigo!");
                Armas armaIgnarok = new Armas("Lança de Ignarok", 30, ataquesIgnarok);
                Escudo escudoIgnarok = new Escudo("Aura Flamejante", 10);
                Outfits armaduraIgnarok = new Outfits("Fogo transparente", 15, 10);
                Equipamento equipamentoBoss = new Equipamento(armaduraIgnarok, armaIgnarok, escudoIgnarok);
                boss = new Boss("Ignarok", 60, 30, 20, Elementos.FIRE, equipamentoBoss);
                break;
            case 2:
                Utilities.limparChat(2);
                System.out.println("Você acaba de entrar na câmara 2.\nSylphira, a Serpente dos Ventos.\nSylphira - Sinta o corte do vendaval, intruso!");

                HashMap<Integer, String> ataquesSylphira = new HashMap<>();
                ataquesSylphira.put(1, "Lâmina de Ar - Uma rajada cortante atinge o inimigo com precisão!");
                ataquesSylphira.put(2, "Redemoinho Cortante - Um vórtice de vento envolve e fere o inimigo!");
                ataquesSylphira.put(3, "Asas da Tempestade - Sylphira bate suas asas com força, criando uma tempestade devastadora!");

                Armas armaSylphira = new Armas("Adaga dos Céus", 27, ataquesSylphira);
                Escudo escudoSylphira = new Escudo("Manto Etéreo", 12);
                Outfits armaduraSylphira = new Outfits("Vestes do Vórtice", 20, 20);
                Equipamento equipamentoSylphira = new Equipamento(armaduraSylphira, armaSylphira, escudoSylphira);
                boss = new Boss("Sylphira", 45, 20, 13, Elementos.SHADOWS, equipamentoSylphira);
                break;
        }
    }
    /**
     * Executa o combate contra a boss final Camellia, com mecânicas de tentativa repetida até vitória.
     */
    @Override
    public void enfrentarBossFinal() {
        Utilities.limparChat(2);
        System.out.println("Uma risada ecoa pelas câmaras vazias...");
        System.out.println("Uma figura encapuzada surge em meio às chamas: é Camellia, a Bruxa do Fogo Eterno!");
        System.out.println("Camellia: Você ousa desafiar as chamas eternas? Queime junto com sua arrogância!");

        HashMap<Integer, String> ataquesCajado = new HashMap<>();
        ataquesCajado.put(1, "Explosão de Cinzas - Uma nuvem de brasas explode contra o inimigo!");
        ataquesCajado.put(2, "Chamas Crescentes - O cajado canaliza fogo crescente e envolve o inimigo!");
        ataquesCajado.put(3, "Inferno Interior - Uma chama interna explode para fora e consome o inimigo!");
        Armas armaCamellia = new Armas("Cajado das Cinzas", 35, ataquesCajado);
        Escudo escudoCamellia = new Escudo("Barreira Incandescente", 20);
        Outfits roupaCamellia = new Outfits("Manto Flamejante", 25, 20);
        Equipamento equipamentoCamellia = new Equipamento(roupaCamellia, armaCamellia, escudoCamellia);

        Boss camellia = new Boss("Camellia", 50, 25, 16, Elementos.FIRE, equipamentoCamellia);


        boolean ganhou = LegendsOfWitches.fighting(LegendsOfWitches.playerGlobal, camellia);
        while(!ganhou){
            if(LegendsOfWitches.playerGlobal.getHealth()<0) {
                System.out.println("Você foi derrotado, mas ainda pode tentar novamente.");
                LegendsOfWitches.playerGlobal.setHealth(120);
                System.out.println("Sua vida foi restaurada!");
                Utilities.limparChat(2);
                System.out.println("Mude seus equipamentos para tentar melhor!");
                LegendsOfWitches.playerGlobal.trocarEquipamento();
                ganhou = LegendsOfWitches.fighting(LegendsOfWitches.playerGlobal, camellia);
            }
        }
        Utilities.limparChat(2);
        System.out.println("Você está pronto para ir para a próxima parte do mapa, " + LegendsOfWitches.playerGlobal.getNome());
        Utilities.limparChat(2);
        LegendsOfWitches.playerGlobal.setHealth(160);
        LegendsOfWitches.playerGlobal.setAttack(100);
        LegendsOfWitches.playerGlobal.setDefense(60);
        System.out.println("Você recebeu level-up. Seus novos status: attack - " + LegendsOfWitches.playerGlobal.getAttack() + " defesa: " + LegendsOfWitches.playerGlobal.getDefense());
        acontecendo = false;
        LegendsOfWitches.mapa2();
    }
}
