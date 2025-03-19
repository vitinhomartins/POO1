public class Main {
    public static void main(String[] args) {
        Turma turma01 = new Turma();
        Turma turma02 = new Turma();
        turma01.setTurma("Turma - primeiro ano");
        turma02.setTurma("Turma - segundo ano");
        turma01.setDisciplina("Programacao orientada a objetos");
        turma02.setDisciplina("Geometria analitica");

        turma01.exibaTurma();
        turma02.exibaTurma();

        System.out.println(turma01.getTurma() + " " + turma01.getDisciplina() + "\n" + turma02.getTurma() + " " + turma02.getDisciplina());
    }
}
