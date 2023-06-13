import java.math.BigInteger;

public class NumberToNepali {


    public static void main(String[] args)
    {
        String numberWordFormat;

        BigInteger n=new BigInteger("150000030000");
        System.out.println("Number = "+n);

        BigInteger divide = null;
        int mod;

        divide = n.divide(new BigInteger("100000000000"));
        mod = divide.mod(new BigInteger("100")).intValue();
        String s0 = genWords(mod, " खर्ब");

        divide = n.divide(new BigInteger("1000000000"));
        mod = divide.mod(new BigInteger("100")).intValue();
        String s = genWords(mod, " अरब");

        divide = n.divide(new BigInteger("10000000"));
        mod = divide.mod(new BigInteger("100")).intValue();
        String s1 = genWords(mod, " करोड");

        divide = n.divide(new BigInteger("100000"));
        mod = divide.mod(new BigInteger("100")).intValue();
        String s2 = genWords(mod, " लाख");

        divide = n.divide(new BigInteger("1000"));
        mod = divide.mod(new BigInteger("100")).intValue();
        String s3 = genWords(mod, " हजार");

        divide = n.divide(new BigInteger("100"));
        mod = divide.mod(new BigInteger("10")).intValue();
        String s4 = genWords(mod, " सय");

        mod = n.mod(new BigInteger("100")).intValue();
        String s5 = genWords(mod, " ");

        numberWordFormat = s0+s + s1 + s2 + s3 + s4 + s5;

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

        String one[] = { " ", " एक", " दुई", " तीन", " चार", " पाँच", " छ", " सात", " आठ", " नौ", " दस"};

        String ten[] = { " ", " ", " एघार", " बाह्र", " तेह्र", " चौध", " पन्ध्र", " सोह्र", " सत्र", " अठार",
                " उन्नाइस", " बिस", " एक्काइस", " बाइस", " तेइस", " चौबिस", " पच्चिस", " छब्बिस"," सत्ताइस"," अट्ठाइस"," उनन्तिस"," तिस",
                " एकतिस", " बत्तिस", " तेत्तिस", " चौतिस", " पैँतिस", " छत्तिस", " सैँतिस", " अठतिस"," उनन्चालिस"," चालिस"," एकचालिस"," बयालिस",
                " त्रिचालिस", " चवालिस", " पैँतालिस", " छयालिस", " सतचालिस", " अठचालिस", " उनन्चास", " पचास"," एकाउन्न"," बाउन्न"," त्रिपन्न"," चवन्न",
                " पचपन्न", " छपन्न", " सन्ताउन्न", " अन्ठाउन्न", " उनसट्ठी", " साठी", " एकसट्ठी", " बयसट्ठी"," त्रिसट्ठी"," चौसट्ठी"," पैँसट्ठी"," छयसट्ठी",
                " सतसट्ठी", " अठसट्ठी", " उनन्सत्तरी", " सत्तरी", " एकहत्तर", " बहत्तर", " त्रिहत्तर", " चौहत्तर"," पचहत्तर"," छयहत्तर"," सतहत्तर"," अठहत्तर",
                " उनासी", " असी", " एकासी", " बयासी", " त्रियासी", " चौरासी", " पचासी", " छयासी"," सतासी"," अठासी"," उनान्नब्बे"," नब्बे",
                " एकान्नब्बे", " बयान्नब्बे", " त्रियान्नब्बे", " चौरान्नब्बे", " पन्चान्नब्बे", " छयान्नब्बे", " सन्तान्नब्बे", " अन्ठान्नब्बे"," उनान्सय"

        };

        String temp;

        if (n > 10)
        {
//            temp = ten[n / 10] + " " + one[n % 10];
            temp = ten[n-9];
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