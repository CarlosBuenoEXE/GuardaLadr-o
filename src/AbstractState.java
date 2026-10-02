public abstract class AbstractState<C> implements State<C> {
    private C character;

    public AbstractState(C character) {
        this.character = character;
    }

    @Override
    public C getCharacter() {
        return character;
    }

    @Override
    public void enter() {
    }

    @Override
    public void leave() {
    }
}