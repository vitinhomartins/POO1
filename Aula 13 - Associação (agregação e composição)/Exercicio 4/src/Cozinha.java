public class Cozinha {
    private Geladeira geladeira;
    private Liquidificador liquidificador;
    private Microondas microondas;

    public Cozinha() {
        geladeira = new Geladeira();
        liquidificador = new Liquidificador();
        microondas = new Microondas();
    }
    public void observar() {
        geladeira.observar();
        microondas.observar();
        liquidificador.observar();
    }
    public void ligar() {
        geladeira.ligar();
        microondas.ligar();
        liquidificador.ligar();
    }
    public void desligar() {
        geladeira.desligar();
        microondas.desligar();
        liquidificador.desligar();
    }
}
