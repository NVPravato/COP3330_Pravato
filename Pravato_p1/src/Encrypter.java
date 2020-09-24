import java.util.Scanner;

public class Encrypter {
    
/* //USER PROMPT MOVED TO MAIN CLASS


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //digits(1234);
        prompt();

    }

    public static void prompt(){
        System.out.println("Would you like to encrypt or decrypt? (you can also type 'E' or 'D')");
        E_or_D();
    }

    public static void E_or_D(){
        Scanner scan = new Scanner(System.in);

        String answer = scan.nextLine();
        if(answer.equalsIgnoreCase("encrypt") || answer.equalsIgnoreCase("e")){
            //enterNum(1);
            Encrypter enc = new Encrypter();
            System.out.println(enc.encrypt(getNumberString()));
        }else if(answer.equalsIgnoreCase("decrypt") || answer.equalsIgnoreCase("d")){
            //decrypt(answer);
        }else{
            errorMessage(answer);
        }
    }

    public static String getNumberString(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your 4-Digit Number");
        String numberString = scan.nextLine();
        return numberString;
    }
*/ //USER PROMPT MOVED TO MAIN CLASS
    public String encrypt(String numberString){
        int number = Integer.parseInt(numberString);
        int d1 = getd1(number);
        int d2 = getd2(number);
        int d3 = getd3(number);
        int d4 = getd4(number);
        //System.out.println("Your Number: " + d1 + d2 + d3 + d4);
        int temp = 0;
        //add 7
        //System.out.println("adding 7");
        d1 += 7;
        d2 += 7;
        d3 += 7;
        d4 += 7;
        //printEncrypt(d1, d2, d3, d4);

        //mod by 10
        //System.out.println("modding by 10");
        //System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);

        d1 %= 10;
        d2 %= 10;
        d3 %= 10;
        d4 %= 10;
        //System.out.println(d1 + d2 + d3 + d4);
        //System.out.println("modded by 10");
        //printEncrypt(d1, d2, d3, d4);

        //swap 1&3 and 2&4
        //System.out.println("swapping");
        temp = d1;
        d1 = d3;
        d3 = temp;

        temp = d2;
        d2 = d4;
        d4 = temp;
        //System.out.println("Your Encrypted Number: " + d1 + d2 + d3 + d4);
        d3 *= 10;
        d2 *= 100;
        d1 *= 1000;
        number = d1 + d2 + d3 + d4;
        String encryptedNumberString =  Integer.toString(number);

        if(d1 == 0){
            //System.out.println("HERE!!");
            encryptedNumberString = "0" + encryptedNumberString;
        }
        //printEncrypt(encryptedNumberString); //no longer needed
        return encryptedNumberString;
    }
/*
    public void encrypt(int d1, int d2, int d3, int d4){
        int temp = 0;

        //add 7
        //System.out.println("adding 7");
        d1 += 7;
        d2 += 7;
        d3 += 7;
        d4 += 7;
        //printEncrypt(d1, d2, d3, d4);

        //mod by 10
        //System.out.println("dividing by 10");
        d1 %= 10;
        d2 %= 10;
        d3 %= 10;
        d4 %= 10;
        //printEncrypt(d1, d2, d3, d4);

        //swap 1&3 and 2&4
        //System.out.println("swapping");
        temp = d1;
        d1 = d3;
        d3 = temp;

        temp = d2;
        d2 = d4;
        d4 = temp;
        //printEncrypt(d1, d2, d3, d4);

        //System.out.println("Your Encrypted Number: " + d1 + d2 + d3 + d4);

        printEncrypt(d1, d2, d3, d4);

    }
*/


    /* //no longer needed
    public static void printEncrypt(String encryptedNumber){
        System.out.println("Your Encrypted Number: " + encryptedNumber);
    }

    public static void enterNum(int DorE){
        Scanner scan = new Scanner(System.in);
        if(DorE == 1){
            System.out.println("Enter the number to encrypt.");
            int answer = scan.nextInt();
            digits(answer, DorE);
        }else if(DorE == 0){
            System.out.println("Enter the number to decrypt.");
            int answer = scan.nextInt();
            digits(answer, DorE);

        }

    }
*/ //no longer needed

    //gets the digits from the 4-digit number (d1 = digit 1, and so on)
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






    public static void digits(int num, int DorE){
        int d1 = num / 1000;
        int d2 = (num % 1000)/100;
        int d3 = (num % 100)/10;
        int d4 = num % 10;
        //System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);
        /*
        if(DorE == 1){
            Encrypter enc = new Encrypter();
            enc.encrypt(d1, d2, d3, d4);
        }else if(DorE == 0){
            Decrypter dec = new Decrypter();
            dec.decrypt(d1, d2, d3, d4);

        }
        */
    }

    /*
    public static void errorMessage(String typed){

        System.out.println("Sorry, I don't understand " + "\"" + typed + "\", please try again");
        prompt();

    }
*/

}
