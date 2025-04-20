public class Zoologico {
    public static void main(String[] args) {
        Animal zoo[] = new Animal[4];
        CriarZoologico zoologico = new CriarZoologico();
        for(int i = 0; i < 4; i++) {
            zoo[i] = zoologico.criarZoo();
            zoo[i].emitirSom();
        }
    }
}

// Explicação do código.

// Gerei uma classe CriarZoologico que recebia um valor randômico e com base nele, eu gerava e retornava
// o endereço do objeto criado para a classe Zoologico (onde o Main pertence).
