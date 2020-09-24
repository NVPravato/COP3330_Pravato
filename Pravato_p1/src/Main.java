import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //int x = 2 % 10;
        //System.out.println(x);
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

            Encrypter enc = new Encrypter();
            System.out.println("Your Encrypted Number: " + enc.encrypt(getNumberString()));
            //String encryptedValue = enc.encrypt("1234");
            //System.out.println("Your encrypted number: " + encryptedValue);
        }else if(answer.equalsIgnoreCase("decrypt") || answer.equalsIgnoreCase("d")){

            Decrypter dec = new Decrypter();
            System.out.println("Your Decrypted Number: " + dec.decrypt(getNumberString()));
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

    public static void errorMessage(String typed){

        System.out.println("Sorry, I don't understand " + "\"" + typed + "\", please try again");
        prompt();

    }
}
