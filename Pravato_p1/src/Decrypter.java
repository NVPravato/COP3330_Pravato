import java.util.Scanner;

public class Decrypter {



    public String decrypt(String numberString){
        int temp = 0;
        int number = Integer.parseInt(numberString);
        //System.out.println(number);

        //separates into digits
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;

        d1 = getd1(number);
        d2 = getd2(number);
        d3 = getd3(number);
        d4 = getd4(number);


        //System.out.println("Your Number: " + d1 + d2 + d3 + d4);

        //swap 1&3 and 2&4
        //System.out.println("swapping");

        //printEncrypt(d1, d2, d3, d4);

        //reverse mod by 10 (add remainder to 10 if <= 6)
        //System.out.println("dividing by 10");
        //System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);

        //if the number is less than 7, it adds 10 as a reverse of the encryption's %10
        if(d1 < 7){
            //System.out.println("hered1");
            d1 += 10;
        }
        if(d2 < 7){
            //System.out.println("hered2");
            d2 += 10;
        }
        if(d2 < 7){
            //System.out.println("hered3");
            d2 += 10;
        }
        if(d2 < 7){
            //System.out.println("hered4");
            d2 += 10;
        }
        //System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);
        //printEncrypt(d1, d2, d3, d4);


        //I had to move the position swapping to after the reversal of the mod 10, not sure why but
        // it seems to fix the issue of it not adding 10 when the number is less than 7
        temp = d1;
        d1 = d3;
        d3 = temp;

        temp = d2;
        d2 = d4;
        d4 = temp;

        //subtract 7
        //System.out.println("subtracting 7");
        d1 -= 7;
        d2 -= 7;
        d3 -= 7;
        d4 -= 7;
        //System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);
        //multiply in order to put the digits back into one number
        d3 *= 10;
        d2 *= 100;
        d1 *= 1000;
        number = d1 + d2 + d3 + d4;
        String decryptedNumberString =  Integer.toString(number);

        if(d1 == 0){
            //System.out.println("HERE!!");
            decryptedNumberString = "0" + decryptedNumberString;
        }

        return decryptedNumberString;



        //System.out.println("Your Encrypted Number: " + d1 + d2 + d3 + d4);

    }

    //Gets the digits of a number (d1 = digit 1, and so on)

    public static int getd1(int num){

        return num / 1000;
    }

    public static int getd2(int num){

        return (num % 1000)/100;
    }

    public static int getd3(int num){

        return (num % 100)/10;
    }

    public static int getd4(int num){

        return num % 10;
    }

}
