public abstract class Personagem {
    private final String nome;

    public Personagem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    /** Executa o ataque e retorna o dano causado. */
    public abstract int atacar();
}
