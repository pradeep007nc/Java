public class LaunchGame {
    public static void main(String[] args) {
        umpire umpire = new umpire();
        umpire.getNumberFromGuesser();
        umpire.getNumberFromPlayers();
        umpire.declareResult();
    }
}
