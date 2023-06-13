import java.math.BigInteger;

public class NumToWord {


    public static void main(String[] args)
    {
        String numberWordFormat;

        BigInteger n=new BigInteger("21782");
        System.out.println("Number = "+n);

        BigInteger divide = null;
        int mod;

        divide = n.divide(new BigInteger("1000000000"));
        mod = divide.mod(new BigInteger("100")).intValue();
        String s = genWords(mod, " arab");

        divide = n.divide(new BigInteger("10000000"));
        mod = divide.mod(new BigInteger("100")).intValue();
        String s1 = genWords(mod, " crore");

        divide = n.divide(new BigInteger("100000"));
        mod = divide.mod(new BigInteger("100")).intValue();
        String s2 = genWords(mod, " lakh");

        divide = n.divide(new BigInteger("1000"));
        mod = divide.mod(new BigInteger("100")).intValue();
        String s3 = genWords(mod, " thousand");

        divide = n.divide(new BigInteger("100"));
        mod = divide.mod(new BigInteger("10")).intValue();
        String s4 = genWords(mod, " hundred");

        mod = n.mod(new BigInteger("100")).intValue();
        String s5 = genWords(mod, " ");

        numberWordFormat = s + s1 + s2 + s3 + s4 + s5;

        System.out.println();
        System.out.println(" Number in string  :: \n" + numberWordFormat);


//        genWords( (n / 1_000_000_000) % 100, " arab");
//        genWords((int) (n / 10_000_000) % 100, " crore");
//        genWords((int) (n / 100000) % 100, " lakh");
//        genWords((int) (n / 1000) % 100, " thousand");
//        genWords((int) (n / 100) % 10, " hundred");
//        genWords((int) n % 100, " ");
    }

    static String genWords(int n, String ch)
    {
        StringBuilder wordFormat = new StringBuilder();

        String one[] = { " ", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
                " Eleven", " Twelve", " Thirteen", " Fourteen", "Fifteen", " Sixteen", " Seventeen", " Eighteen",
                " Nineteen" };

        String ten[] = { " ", " ", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety" };

        String temp;

        if (n > 19)
        {
            temp = ten[n / 10] + " " + one[n % 10];
            //System.out.print(ten[n / 10] + " " + one[n % 10]);
            wordFormat.append(temp);
        }
        else
        {
            temp = one[n];
            //System.out.print(one[n]);
            wordFormat.append(temp);
        }
        if (n > 0){
           // System.out.print(ch);
            wordFormat.append(ch);
        }

        return wordFormat.toString();
    }
}