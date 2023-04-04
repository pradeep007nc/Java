import java.util.Scanner;

public class guesser {
    int num;
    public int guessNumber() {
        System.out.println("hi guesser guess the number");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        return num;
    }
}
