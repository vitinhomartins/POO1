public class Compositor {
    private String codigo, nome;
    public Compositor() {
        codigo = "Código desconhecido";
        nome = "Nome desconhecido";
    }
    public Compositor(String nome, String codigo) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public String nomeCompositor() {
        return nome;
    }
    public String codigoCompositor() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
