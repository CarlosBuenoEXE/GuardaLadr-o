public interface Character {
    void printStats(String status);
    void update();
    void setState(State<Character> newState);
}