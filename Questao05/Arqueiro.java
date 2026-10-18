import java.util.Random;

public class Arqueiro extends Personagem {
    private final Random random = new Random();

    public Arqueiro(String nome) {
        super(nome);
    }

    @Override
    public int atacar() {
        int flechas = 3;
        int total = 0;
        for (int i = 0; i < flechas; i++) {
            total += 5 + random.nextInt(6); // 5 a 10 por flecha
        }
        System.out.println(getNome() + " (Arqueiro) dispara " + flechas + " flechas. Dano total: " + total);
        return total;
    }
}
