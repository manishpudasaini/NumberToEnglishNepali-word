package practice;

import java.util.Scanner;

public class NumberToWord

{
    private static final String[] higherNames = { "", " thousand", " million", " billion", " trillion", " quadrillion",
            " quintillion" };

    private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
            " seventy", " eighty", " ninety" };

    private static final String[] onesNames = { "", " one", " two", " three", " four", " five", " six", " seven",
            " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
            " seventeen", " eighteen", " nineteen" };

    private String convertLessThanOneThousand(long n) {
        String current;

        if (n % 100 < 20) {
            current = onesNames[(int) (n % 100)];
            n /= 100;
        } else {
            current = onesNames[(int) (n % 10)];
            n /= 10;

            current = tensNames[(int) (n % 10)] + current;
            n /= 10;
        }
        if (n == 0)
            return current;
        return onesNames[(int) n] + " hundred" + current;
    }

    public String convert(String input) {
        long number=0;
        //Validate the input
        String result = validate(input);
        if (result != null) {
            return result;
        }else {
            number=Long.parseLong(input);
        }

        String prefix = "";
        //check number is negative then prefix with negative
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        String current = "";
        int place = 0;

        do {
            //break the number in 3 digits from right and convert number to name
            long n = number % 1000;
            if (n != 0) {
                String s = convertLessThanOneThousand(n);
                current = s + higherNames[place] + current;
            }
            //increment the place when going to next higher number
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();

        NumberToWord obj = new NumberToWord();
        System.out.println("Input  *** " + readString);
        System.out.println("Output *** " + obj.convert(readString));

    }

    private String validate(String readString) {
        // TODO Auto-generated method stub
        long input;
        String result = null;
        if (readString.trim().isEmpty()) {
            result = "Please enter an input";
        } else {
            try {
                input = Long.parseLong(readString);
                if (input == 0) {
                    return "zero";
                }
                if (input > 999999999) {
                    return "please enter number below 999999999";
                }
            } catch (NumberFormatException e) {
                result = "Not an Number";
            } catch (Exception e) {
                //e.printStackTrace();
                result = e.getMessage();
            }
        }
        return result;
    }
}