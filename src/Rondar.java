public class Rondar extends AbstractState<Character> {
    private Guarda guarda;

    public Rondar(Guarda guarda) {
        super(guarda);
        this.guarda = guarda;
    }

    @Override
    public void enter() {
        guarda.printStats("Iniciou a ronda.");
    }

    @Override
    public void execute() { // ve se o ladrao ta na porta, mesma coisa do outro, só q assim evita dele fazer aquiolo de voltar do café e cagar pro ladrão do lado dele
        if (guarda.ladrao.stateMachine.getCurrentState() instanceof Arrombando) {
            System.out.println("[Guarda] Pegou o ladrão na porta e bateu nele");
            guarda.ladrao.vidas--;
            guarda.ladrao.setState(new Esconder(guarda.ladrao));
        }

        guarda.energia--; // gasta a energia 
        guarda.printStats("Rondando.");

        if (guarda.energia <= 0) { // vai tomar cafe se chegar a zero 
            guarda.setState(new HoraDoCafe(guarda));
        }
    }

    @Override
    public void leave() {
        System.out.println("[Guarda] Termina ronda.");
    }
}