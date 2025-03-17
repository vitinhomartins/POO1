public class Teste {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        Universidade universidade = new Universidade();
        aluno.nome = "Vitinho";
        aluno.curso = "Ciência da computação";
        universidade.cidade = "Guarapuava";
        universidade.estado = "Paraná";
        universidade.nome = "UNICENTRO";
        universidade.exibeDados();
        aluno.exibeDados();
    }
}
