public class Geladeira {
    private boolean ligado;
    public Geladeira() {
        ligado = false;
    }
    public void ligar() {
        ligado = true;
        System.out.println("Geladeira ligada");
    }
    public void desligar() {
        ligado = false;
        System.out.println("Geladeira desligada");
    }
    public boolean isLigado() {
        return ligado;
    }
    public String observar() {
        if(!isLigado()) return "A geladeira está desligada";
        return "A geladeira está ligada";
    }
}
