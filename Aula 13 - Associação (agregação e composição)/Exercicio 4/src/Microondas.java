public class Microondas {
    private boolean ligado;
    public Microondas() {
        ligado = false;
    }
    public void ligar() {
        ligado = true;
        System.out.println("Microondas desligado");
    }
    public void desligar() {
        ligado = false;
        System.out.println("Microondas desligado");
    }
    public boolean isLigado() {
        return ligado;
    }
    public String observar() {
        if(!isLigado()) return "O microondas está desligado";
        return "O microondas está ligado";
    }
}
