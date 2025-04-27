public class Liquidificador {
    private boolean ligado;
    public Liquidificador() {
        ligado = false;
    }
    public void ligar() {
        ligado = true;
        System.out.println("Liquidificador ligado");
    }
    public void desligar() {
        ligado = false;
        System.out.println("Liquidificador desligado");
    }
    public boolean isLigado() {
        return ligado;
    }
    public String observar() {
        if(!isLigado()) return "O liquidificador está desligado";
        return "O liquidificador está ligado";
    }
}
