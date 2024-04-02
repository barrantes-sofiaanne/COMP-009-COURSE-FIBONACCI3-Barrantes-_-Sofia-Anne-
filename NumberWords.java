package fibonacci;

public class NumberWords{
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a number: ");
            return;
        }
        int number;
        try {
            number = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Please provide a valid whole number.");
            return;
        }
        String words = convertToWords(number);
        System.out.println("The converted number is " + words);
    }
    public static String convertToWords(int number) {
        if (number < 0) {
            return "Negative " + convertToWords(-number);
        }
        if (number < 20) {
            return units(number)+", ";
        }
        if (number < 100) {
            return tens(number / 10) + ", " + units(number % 10);
        }
        if (number < 1000) {
            return units(number / 100) + " Hundred " + convertToWords(number % 100);
        }
        if (number < 1000000) {
            if (number % 1000 == 0) {
                return convertToWords(number / 1000) + " Thousand " + convertToWords(number % 1000);
            } else {
                return convertToWords(number / 1000) + " Thousand, " + convertToWords(number % 1000);
            }
        }
        return convertToWords(number / 1000000) + " Million " + convertToWords(number % 1000000);
    }


    private static String units(int number) {
        String[] units = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                          "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        return units[number];
    }

    private static String tens(int number) {
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        return tens[number];
    }
}

