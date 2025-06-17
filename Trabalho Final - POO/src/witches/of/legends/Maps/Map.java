package witches.of.legends.Maps;

import witches.of.legends.Utilities.ChamberAlreadyCompletedException;

public abstract class Map {
    private int numberMap;
    private static boolean concluido;
    public Map(int numberMap){
        this.numberMap = numberMap;
    }

    abstract String getNome();

    abstract void iniciarMapa();

    abstract void entrarChamber(int numero) throws ChamberAlreadyCompletedException;

    abstract void enfrentarBossFinal();

    public static boolean podeAvancar(){
        return concluido;
    }
}