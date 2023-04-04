public class umpire {
    int guessedValue;
    boolean wins;
    int count=0;
    guesser guesser = new guesser();
    int[] playersGuess = new int[3];
    player[] players = new player[3];
    public void getNumberFromGuesser() {
        guessedValue = guesser.guessNumber();
    }

    public void getNumberFromPlayers() {
        for (int i=0;i<3;i++) {
            players[i] = new player();
            playersGuess[i] = players[i].getNumber();
        }
    }

    public void declareResult() {
       for (int i: playersGuess){
           if (i == guessedValue) wins = true;
           count++;
           System.out.printf("the player %d guess is %d\n",count,i);
           if (wins){
               System.out.printf("the player %d won\n", count);
               wins = false;
           }else{
               System.out.println("the player "+count+" lost");
           }
       }
    }
}
