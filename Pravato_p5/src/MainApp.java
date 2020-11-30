import java.util.*;
import java.io.*;

public class MainApp {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Select Your Application\n-----------------------\n\n1) task list\n2) contact list\n3) quit");
        int selection  = scan.nextInt();
        scan.nextLine();

        switch (selection) {

            case 1:
                TaskApp.main(null);
                break;
            case 2:
                ContactApp.main(null);
                break;
            case 3:

                break;
            default:
                System.out.println("Invalid selection return from selMain, this should never happen");
                break;
        }
    }
}
