public class Palestra {
    private Luz estado;
    public Palestra(Luz luz) {
        estado = luz;
    }
    public void verificaEstado() {
        switch(estado){
            case VERDE:
                System.out.println("Palestra disponível");
                break;
            case AMBAR:
                System.out.println("Palestra sendo liberada");
                break;
            case VERMELHO:
                System.out.println("Palestra indisponível");
        }
    }
}
