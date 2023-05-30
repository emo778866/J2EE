import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        switch (line) {
            case "hello" -> System.out.println("It is greeting time!");
            case "bye" -> System.out.println("It is go home time!");
            default -> System.out.println("Who knows what!");
        }
    }
}
