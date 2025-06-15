package witches.of.legends.Utilities;

public class ChamberAlreadyCompletedException extends Exception{
    public ChamberAlreadyCompletedException(int numero) {
        super("A sala " + numero + " já foi concluída!");
    }
}
