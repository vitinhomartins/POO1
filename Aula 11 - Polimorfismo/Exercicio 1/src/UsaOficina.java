public class UsaOficina {
    public static void main(String[] args) {
        Oficina oficina = new Oficina();
        Veiculo veiculo;
        for(int i = 0; i < 4; i++) {
            System.out.println("Veículo número: " + i);
            veiculo = oficina.proximo();
            oficina.revisar(veiculo);
        }
    }
}
