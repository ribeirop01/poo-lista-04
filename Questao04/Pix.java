public class Pix extends Pagamento {
    private static final double DESCONTO = 0.05; // 5%

    @Override
    public void processar(double valor) {
        double total = valor * (1 - DESCONTO);
        System.out.printf("Pix: valor R$ %.2f com desconto de 5%% = R$ %.2f%n", valor, total);
    }
}
