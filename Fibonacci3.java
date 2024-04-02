package fibonacci;
import java.util.Scanner;

abstract class NumberConverter {
    public abstract String convertToWords(int number);
}

class FibonacciWordsConverter extends NumberConverter {
    private NumberWords numberWords2;

    public FibonacciWordsConverter() {
        this.numberWords2 = new NumberWords();
    }

    public String convertToWords(int number) {
        return numberWords2.convertToWords(number);
    }
}
class NumberDigitsConverter extends NumberConverter {
    public String convertToWords(int number) {
        // Implementation of converting numbers to digits
        // For this example, let's just return the number as a string
        return String.valueOf(number);
    }
}

public class Fibonacci3 {
    public static void main(String[] args) {
        System.out.println("Welcome to Fibonacci Series!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements do you want? : ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Do you want it in words or numbers? (Answer in Uppercase) : ");
        String decision = scanner.nextLine().toUpperCase();

        NumberConverter converter;
        if (decision.equals("WORDS")) {
            converter = new FibonacciWordsConverter();
        } else if (decision.equals("NUMBERS")) {
            converter = new NumberDigitsConverter();
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        // Generate the Fibonacci series
        int[] series = new int[n];
        series[0] = 0;
        if (n > 1) {
            series[1] = 1;
            for (int i = 2; i < n; i++) {
                series[i] = series[i - 1] + series[i - 2];
            }
        }

        System.out.println("Fibonacci Series:");
        for (int num : series) {
            System.out.print(converter.convertToWords(num) + " ");
        }

        scanner.close();
    }
}
