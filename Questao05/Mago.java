public class Mago extends Personagem {
    private int mana = 30;

    public Mago(String nome) {
        super(nome);
    }

    @Override
    public int atacar() {
        if (mana >= 10) {
            mana -= 10;
            int dano = 35;
            System.out.println(getNome() + " (Mago) lança uma bola de fogo! Dano: " + dano + " (mana restante: " + mana + ")");
            return dano;
        }
        System.out.println(getNome() + " (Mago) está sem mana e usa o cajado. Dano: 5");
        return 5;
    }
}
