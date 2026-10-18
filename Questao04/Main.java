public class Main {
    public static void main(String[] args) {
        Pagamento[] pagamentos = { new CartaoCredito(), new Boleto(), new Pix() };
        double valor = 200.00;

        for (Pagamento p : pagamentos) {
            p.processar(valor); // polimorfismo: cada forma aplica sua própria regra
        }
    }
}
