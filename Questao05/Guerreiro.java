import java.util.Random;

public class Guerreiro extends Personagem {
    private final Random random = new Random();

    public Guerreiro(String nome) {
        super(nome);
    }

    @Override
    public int atacar() {
        int dano = 20;
        if (random.nextInt(100) < 25) { // 25% de chance de crítico
            dano *= 2;
            System.out.println(getNome() + " (Guerreiro) acerta um GOLPE CRÍTICO de espada! Dano: " + dano);
        } else {
            System.out.println(getNome() + " (Guerreiro) golpeia com a espada. Dano: " + dano);
        }
        return dano;
    }
}
