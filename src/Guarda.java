public class Guarda implements Character {
    public int energia = 10; // Energia inicial
    public StateMachine<Character> stateMachine;
    public Ladrao ladrao;

    public Guarda() {
        this.stateMachine = new StateMachine<>();
        this.stateMachine.changeState(new Rondar(this));
    }

    @Override
    public void printStats(String message) {
        System.out.println("[Guarda] " + message + " | Energia: " + energia);
    }

    @Override
    public void update() {
        stateMachine.update();
    }

    @Override
    public void setState(State<Character> newState) {
        stateMachine.changeState(newState);
    }

    public void alertaBarulho() { // Aqui é onde o guarda escuta o vagabundo >:(
        if (stateMachine.getCurrentState() instanceof HoraDoCafe) {
            System.out.println("[Guarda] Ouviu um barulho enquanto tomava café!");
            stateMachine.changeState(new Procurando(this)); // qquando ele escuta ele muda pra "Procurando" (Só quando ele ta tomando café)
        }
    }
}