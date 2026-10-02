public class Esconder extends AbstractState<Character> {
    private Ladrao ladrao;

    public Esconder(Ladrao ladrao) {
        super(ladrao);
        this.ladrao = ladrao;
    }

    @Override
    public void enter() {
        ladrao.printStats("Se escondeu nas sombras."); //quando ele ta sem energia
    }

    @Override
    public void execute() {
        if (ladrao.energia < 7) {
            int recuperado = (Math.random() < 0.5) ? 1 : 2; // agora é aleatorio entre 1 e 2 pra n ficar muito repetitivo e da uma boa variada nas rodadas
            ladrao.energia += recuperado;
            if (ladrao.energia > 7) ladrao.energia = 7; // pra n ficar com mais q 7
            ladrao.printStats("Recuperando energia escondido (+ " + recuperado + ").");
        }
        if (ladrao.energia >= 7) { // manda ele pro outro estado quando ta no max
            ladrao.setState(new Observar(ladrao));
        }
    }

    @Override
    public void leave() {
        System.out.println("[Ladrão] Saiu do esconderijo.");
    }
}