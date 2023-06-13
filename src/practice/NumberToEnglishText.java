package practice;

import java.util.List;
import java.util.Scanner;

public class NumberToEnglishText {

    public static void NumberToEnglish(String num){

        //converting the string to char array
        char[] number = num.toCharArray();

        //length of the array
        int length = number.length;

        List<String> onedigit = List.of("Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine");
        List<String> twodigit = List.of("","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen");
        List<String> higherTwoDigit = List.of("","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety");
        List<String> higherNumber = List.of("Hundred","Thousand","Lakh","Corer","Arab");

        if(length == 0){
            System.out.println("The number is empty!!");
            return;
        }

        if(length == 1){
            System.out.println(onedigit.get(number[0]-'0'));
            return;
        }

        int x = 0;
//executes until num does not become not '\0'
        while (x < number.length)
        {
//executes if the length of the string is greater than equal to three
            if(length >=5){
                if (number[x] - '0' != 0){
                    System.out.print(higherTwoDigit.get(number[0]-'0' - 1)+ " ");


                }
            }

            if (length >= 3)
            {
                if (number[x] - '0' != 0)
                {

                    System.out.print(onedigit.get(number[x] - '0') + " ");
//here length can be 3 or 4
                    System.out.print(higherNumber.get(length - 3)+ " ");
                }
//decrements the length of the string by 1
                --length;
            }
//executes if the given number has two digits
            else
            {
//the if-statement handles the numbers from 10 to 19 only
                if (number[x] - '0' == 1)
                {
//adding the digits of the given number
//the logic behind sum up the digits is that we will use the sum for accessing the index of the array
//for example: 17, sum of digits = 8
//we will access the 8th index in twodigits[] array i.e. Seventeen
                    int sum = number[x] - '0' + number[x + 1] - '0';
                    System.out.println(twodigit.get(sum));
                    return;
                }
//the else-if statement handles the number 20 only
//compares the tens and unit place with 2 and 0 respectively
                else if (number[x] - '0' == 2 && number[x + 1] - '0' == 0)
                {
//executes if the above else-if condition returns true
                    System.out.println("Twenty");
                    return;
                }
//the else block handles the numbers from 21 to 100
                else
                {
                    int i = (number[x] - '0');
                    if (i > 0)
//prints the ith index element of the array multipleoftens[]
                        System.out.print(higherTwoDigit.get(i)+ " ");
                    else
//prints space
                        System.out.print("");
//increments the variable i by 1
                    ++x;
//checks whether the number is not equal to zero, it means the number has only a digit
                    if (number[x] - '0' != 0)
//prints the ith index element of the array onedigit[]
                        System.out.println(onedigit.get(number[x] - '0'));
                }
            }
//increments the variable i by 1
            ++x;
        }
    }

    public static void main(String[] args) {
        NumberToEnglish("48321");

    }

}
