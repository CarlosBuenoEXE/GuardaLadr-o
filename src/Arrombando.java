public class Arrombando extends AbstractState<Character> {
    private Ladrao ladrao;

    public Arrombando(Ladrao ladrao) {
        super(ladrao);
        this.ladrao = ladrao;
    }

    @Override
    public void enter() {
        ladrao.printStats("Iniciou tentativa de arrombamento!");
    }

    @Override
    public void execute() {
        ladrao.energia--;
        System.out.print("[Ladrão] Forçando a porta... ");

        if (Math.random() < 0.5) { // fiz esse aqui pra n acontecer denovo de ficar rodando infinito, tem tb na energia
            ladrao.progressoArrombamento++;
            System.out.println("Sucesso! Progresso: " + ladrao.progressoArrombamento + "/3");
        } else {
            if (Math.random() < 0.65) { // agopra é aletorio tb se vai fazer barulho ou não
                System.out.println("Fracasso e fez BARULHO!");
                ladrao.guarda.alertaBarulho();
            } else {
                System.out.println("Fracasso, mas foi silencioso.");
            }
        }

        if (ladrao.energia <= 0 && ladrao.stateMachine.getCurrentState() == this) { // se ele zera a energia ele vai se esconder denovo
            System.out.println("[Ladrão] Ficou sem energia para arrombar.");
            ladrao.setState(new Esconder(ladrao));
        }
    }

    @Override
    public void leave() {
        System.out.println("[Ladrão] Afastou-se da porta.");
    }
}