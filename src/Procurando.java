public class Procurando extends AbstractState<Character> {
    private Guarda guarda;

    public Procurando(Guarda guarda) {
        super(guarda);
        this.guarda = guarda;
    }

    @Override
    public void enter() {
        guarda.printStats("Em alerta! Indo ver oque fez o barulho...");
    }

    @Override
    public void execute() { // ve se o ladrão ainda esta arrombando a porta
        if (guarda.ladrao.stateMachine.getCurrentState() instanceof Arrombando) {
            System.out.println("[Guarda] Pegou o ladrão na porta e bateu nele");
            guarda.ladrao.vidas--; // Diminui a vida do vagabundo
            guarda.ladrao.setState(new Esconder(guarda.ladrao)); // ladrão se esconde depois de tomar uma surra
        } else {
            System.out.println("[Guarda] Chegou, mas não encontrou ninguém.");
        }
        guarda.setState(new Rondar(guarda)); // vai direto pra ronda, independente da energia
    }

    @Override
    public void leave() {
        System.out.println("[Guarda] Busca finalizada.");
    }
}