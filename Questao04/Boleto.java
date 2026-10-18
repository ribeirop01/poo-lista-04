public class Boleto extends Pagamento {
    private static final double TAXA_FIXA = 3.50;

    @Override
    public void processar(double valor) {
        double total = valor + TAXA_FIXA;
        System.out.printf("Boleto: valor R$ %.2f + taxa fixa de R$ %.2f = R$ %.2f%n", valor, TAXA_FIXA, total);
    }
}
