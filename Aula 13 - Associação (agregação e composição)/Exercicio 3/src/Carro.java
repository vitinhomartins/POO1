public class Carro {
    private String marca;
    private String modelo;
    private String fabricante;
    private Motor motor;
    private Bancos bancos;
    public Carro(String marca, String modelo, String fabricante, Motor motor, Bancos bancos) {
        this.fabricante = fabricante;
        this.motor = motor;
        this.marca = marca;
        this.modelo = modelo;
        this.bancos = bancos;
    }
    @Override
    public String toString() {
        return "Carro: " + marca + " modelo: " + modelo + " fabricante: " + fabricante + motor.toString() + bancos.toString();
    }
}
