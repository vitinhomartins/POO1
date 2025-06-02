public class ValorNegativoException extends Exception {
    private double valor;

    public ValorNegativoException(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Operação inválida: não é possível realizar depósito ou saque com valor negativo (valor informado: R$ " + valor + ")";
    }
}