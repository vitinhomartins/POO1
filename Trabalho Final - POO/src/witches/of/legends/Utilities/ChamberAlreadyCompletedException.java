package witches.of.legends.Utilities;

public class ChamberAlreadyCompletedException extends Exception{
    /**
     * Exceção lançada quando o jogador tenta acessar uma câmara já concluída no mapa subterrâneo.
     * Fornece uma mensagem indicando qual sala já foi finalizada.
     *
     * @author Victor Hugo e Manuela
     * @param numero o número da sala que já foi concluída.
     */
    public ChamberAlreadyCompletedException(int numero) {
        super("A sala " + numero + " já foi concluída!");
    }
}
