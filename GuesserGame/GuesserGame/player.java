import java.util.Scanner;

public class player {
    int guessedNumber;
    public int getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("hi player guess the number");
        guessedNumber = sc.nextInt();
        return guessedNumber;
    }
}
