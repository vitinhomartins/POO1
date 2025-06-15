package witches.of.legends.PlayerStuff;

import witches.of.legends.Utilities.ItemIndexInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogador extends Personagem implements JogadorAcoes {

    public Jogador(String nome, double health, int attack, int defense, Elementos tipoElemental, Equipamento equipamento) {
        super(nome, health, attack, defense, tipoElemental, equipamento);
    }

    @Override
    public void trocarEquipamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- TROCA DE EQUIPAMENTOS ---");

        while (true) {
            try {
                System.out.println("\nArmas disponíveis:");
                for (int i = 0; i < this.getEquipamento().getArmas().size(); i++) {
                    Armas arma = this.getEquipamento().getArmas().get(i);
                    System.out.println("[" + i + "] " + arma.getNome() + " | Dano: " + arma.getAttack());
                }
                System.out.print("Escolha a arma a ser equipada (número): ");
                int escolhaArma = scanner.nextInt();

                if (escolhaArma < 0 || escolhaArma >= this.getEquipamento().getArmas().size()) {
                    throw new ItemIndexInvalidoException("Índice de arma inválido.");
                }

                Armas armaEscolhida = this.getEquipamento().getArmas().get(escolhaArma);
                this.setArmaAtual(armaEscolhida);
                System.out.println("Arma equipada com sucesso!");
                break;

            } catch (ItemIndexInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine(); // Limpa buffer
            }
        }
        while (true) {
            try {
                System.out.println("\nEscudos disponíveis:");
                for (int i = 0; i < this.getEquipamento().getEscudos().size(); i++) {
                    Escudo escudo = this.getEquipamento().getEscudos().get(i);
                    System.out.println("[" + i + "] " + escudo.getNome() + " | Defesa: " + escudo.getDefense());
                }
                System.out.print("Escolha o escudo a ser equipado (número): ");
                int escolhaEscudo = scanner.nextInt();

                if (escolhaEscudo < 0 || escolhaEscudo >= this.getEquipamento().getEscudos().size()) {
                    throw new ItemIndexInvalidoException("Índice de escudo inválido.");
                }

                Escudo escudoEscolhido = this.getEquipamento().getEscudos().get(escolhaEscudo);
                this.setEscudoAtual(escudoEscolhido);
                System.out.println("Escudo equipado com sucesso!");
                break;

            } catch (ItemIndexInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }

        // Trocar roupa
        while (true) {
            try {
                System.out.println("\nRoupas/Armaduras disponíveis:");
                for (int i = 0; i < this.getEquipamento().getRoupas().size(); i++) {
                    Outfits roupa = this.getEquipamento().getRoupas().get(i);
                    System.out.println("[" + i + "] " + roupa.getNome() + " | Defesa: " + roupa.getDefense());
                }
                System.out.print("Escolha a roupa a ser equipada (número): ");
                int escolhaRoupa = scanner.nextInt();

                if (escolhaRoupa < 0 || escolhaRoupa >= this.getEquipamento().getRoupas().size()) {
                    throw new ItemIndexInvalidoException("Índice de roupa inválido.");
                }

                Outfits roupaEscolhida = this.getEquipamento().getRoupas().get(escolhaRoupa);
                this.setRoupaAtual(roupaEscolhida);
                System.out.println("Roupa equipada com sucesso!");
                break;

            } catch (ItemIndexInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }
        while (true) {
            try {
                System.out.println("\nElementos disponíveis:");
                Elementos[] elementos = Elementos.values();
                for (int i = 0; i < elementos.length; i++) {
                    System.out.println("[" + i + "] " + elementos[i]);
                }

                System.out.print("Escolha o tipo elemental (número): ");
                int escolhaElemento = scanner.nextInt();

                if (escolhaElemento < 0 || escolhaElemento >= elementos.length) {
                    System.out.println("Índice inválido. Tente novamente.");
                    continue;
                }

                this.setTipoElemental(elementos[escolhaElemento]);
                System.out.println("Elemento atualizado para: " + elementos[escolhaElemento]);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine(); // limpa buffer
            }
        }

        System.out.println("\n--- Equipamentos atualizados com sucesso! ---");
    }



}