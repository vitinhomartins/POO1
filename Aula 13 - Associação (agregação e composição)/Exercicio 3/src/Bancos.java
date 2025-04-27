public class Bancos {
    private String fabricante;
    Bancos(String fabricante) {
        this.fabricante = fabricante;
    }
    @Override
    public String toString() {
        return " Fabricante bancos: " + fabricante;
    }
}
