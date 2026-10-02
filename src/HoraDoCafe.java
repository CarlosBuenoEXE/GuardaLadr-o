public class HoraDoCafe extends AbstractState<Character> {
    private Guarda guarda;

    public HoraDoCafe(Guarda guarda) {
        super(guarda);
        this.guarda = guarda;
    }

    @Override
    public void enter() {
        guarda.printStats("Foi tomar café.");
    }

    @Override
    public void execute() {
        int recuperado = (Math.random() < 0.5) ? 1 : 2; // mesma coisa do ladrão
        guarda.energia += recuperado;
        if (guarda.energia > 10) guarda.energia = 10; // pra n acabar ficando com mais de 10

        guarda.printStats("Tomando café (+ " + recuperado + " energia).");

        if (guarda.energia >= 10) {
            guarda.setState(new Rondar(guarda));
        }
    }

    @Override
    public void leave() {
        System.out.println("[Guarda] Saiu da sala de café.");
    }
}