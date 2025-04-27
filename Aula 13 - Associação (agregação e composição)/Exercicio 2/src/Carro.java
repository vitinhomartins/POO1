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
    public String getMotor() {
        return motor.getTipo();
    }
    public String getMarca() {
        return marca;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }
    public String getBancos() {
        return bancos.getFabricante();
    }
}
