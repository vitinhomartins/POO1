public class DiversaoApp {
    public static void main(String[] args) {
        Diversao diversao;
        diversao = Diversao.PESCAR;

        switch(diversao) {
            case LER:
                System.out.println("Vou ler o livro Admirável mundo novo");
                break;
            case JOGAR:
                System.out.println("Vou jogar Xadrez");
                break;
            case PASSEAR:
                System.out.println("Vou passear no parque");
                break;
            case PESCAR:
                System.out.println("Vou pescar na Lágoa das Lágrimas");
                break;
            case CONVERSAR:
                System.out.println("Vou conversar com o pessoal de Computação");
        }
    }
}
