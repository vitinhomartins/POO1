public class PalestraApp {
    public static void main(String[] args) {
        Palestra[] palestras = new Palestra[3];
        palestras[0] = new Palestra(Luz.VERDE);
        palestras[1] = new Palestra(Luz.AMBAR);
        palestras[2] = new Palestra(Luz.VERMELHO);

        // testando
        palestras[0].verificaEstado();
        palestras[1].verificaEstado();
        palestras[2].verificaEstado();
    }
}
