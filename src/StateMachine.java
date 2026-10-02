public class StateMachine<C> {
    private State<C> currentState;

    public void changeState(State<C> newState) {
        if (currentState != null) {
            currentState.leave();
        }
        currentState = newState;
        if (currentState != null) {
            currentState.enter();
        }
    }

    public void update() {
        if (currentState != null) {
            currentState.execute();
        }
    }

    public State<C> getCurrentState() {
        return currentState;
    }
}