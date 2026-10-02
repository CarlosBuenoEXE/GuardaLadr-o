public class Observar extends AbstractState<Character> {
    private Ladrao ladrao;

    public Observar(Ladrao ladrao) {
        super(ladrao);
        this.ladrao = ladrao;
    }

    @Override
    public void enter() {
        ladrao.printStats("Observando o guarda.");
    }

    @Override
    public void execute() {
        ladrao.energia--; // aqui é pra gastar a energia
        ladrao.printStats("Observando.");

        if (ladrao.guarda.stateMachine.getCurrentState() instanceof HoraDoCafe) { // aqui ele ta esperando ele ir tomar o cafézinho dele
            ladrao.setState(new Arrombando(ladrao)); // se sim ele vai pra porta
        } else if (ladrao.energia <= 0) { // se chegar a zerop ele volta a se esconder
            ladrao.setState(new Esconder(ladrao));
        }
    }

    @Override
    public void leave() {
        System.out.println("[Ladrão] Parou de observar.");
    }
}