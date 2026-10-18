public class Main {
    public static void main(String[] args) {
        Personagem[] grupo = {
            new Guerreiro("Thor"),
            new Mago("Merlin"),
            new Arqueiro("Legolas")
        };

        int vidaMonstro = 100;
        System.out.println("=== Turno de combate contra o monstro (vida: " + vidaMonstro + ") ===");

        for (Personagem p : grupo) {
            vidaMonstro -= p.atacar(); // polimorfismo: cada personagem ataca à sua maneira
        }

        System.out.println("Vida restante do monstro: " + Math.max(vidaMonstro, 0));
        System.out.println(vidaMonstro <= 0 ? "O monstro foi derrotado!" : "O monstro sobreviveu ao turno.");
    }
}
