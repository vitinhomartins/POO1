public class Turma {
    private String turma, disciplina;

    public String getDisciplina() {
        return disciplina;
    }
    public String getTurma() {
        return turma;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    public void exibaTurma() {
        System.out.println(this.turma + " " + this.disciplina);
    }
}
