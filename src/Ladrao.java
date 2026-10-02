public class Ladrao implements Character {
    public int energia = 7; // Energia inicial
    public int vidas = 2; // vidas
    public int progressoArrombamento = 0; // Quantas vez elee conseguiu forçar a porta certo
    public StateMachine<Character> stateMachine;
    public Guarda guarda;

    public Ladrao() {
        this.stateMachine = new StateMachine<>();
        this.stateMachine.changeState(new Esconder(this)); // ele sempr comeca no "Esconder"
    }

    @Override
    public void printStats(String message) {
        System.out.println("[Ladrão] " + message + " | Energia: " + energia + " | Vidas: " + vidas + " | Progresso: " + progressoArrombamento + "/3");
    }

    @Override
    public void update() {
        stateMachine.update();
    }

    @Override
    public void setState(State<Character> newState) {
        stateMachine.changeState(newState);
    }
}