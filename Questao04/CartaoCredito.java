public class CartaoCredito extends Pagamento {
    private static final double TAXA = 0.0299; // 2,99%

    @Override
    public void processar(double valor) {
        double total = valor * (1 + TAXA);
        System.out.printf("Cartão de Crédito: valor R$ %.2f + taxa de 2,99%% = R$ %.2f%n", valor, total);
    }
}
