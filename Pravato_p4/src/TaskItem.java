import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.*;

public class TaskItem {

    private String title;
    private String desc;
    private String due;
    private boolean completed;
    //private int index;


    public TaskItem(){
        //setTitle();
        //setDesc();
        //setDue();
        /*
        int tValid = setTitle();
        int deValid = setDesc();
        int duValid = setDue();

        if(tValid == deValid && deValid == duValid && duValid == 1){

        }
        */
    }

    public boolean setTitle(String input)throws InputMismatchException {
        boolean valid = false;
        //Scanner scan = new Scanner(System.in);
        //String input = "";

        //do{

            //input = scan.nextLine();
            if(input.length() < 1){
                valid = false;
                System.out.println("WARNING: title must be at least 1 character long; task not created");
                throw new InputMismatchException();
                //return valid;
                //break;
            }else{
                valid = true;
                this.title = input;
                return valid;
                //break;
            }

        //}while(!valid);

        /*
        if(input.length() < 1){
            System.out.println("WARNING: title must be at least 1 character long; task not created");
            return 0;
        }else{
            this.title = input;
            return 1;
        }
        */
    }

    public boolean setDesc(String input)throws InputMismatchException {
        boolean valid = true;

        Scanner scan = new Scanner(System.in);

        //String input = scan.nextLine();
        this.desc = input;
        return true;

        /*
        if(input.length() < 1){
            System.out.println("WARNING: description must be at least 1 character long; task not created");
            return 0;
        }else{
            this.desc = input;
            return 1;
        }
         */
    }

    public boolean setDue(String input) throws InputMismatchException{


        boolean valid = true;
        Scanner scan = new Scanner(System.in);
        //make a for loop checking if they are digits, chars @ 2 and 5 should be '-'
        //int valid = 1;

        do{


            //check 10 character length
            if(input.length() != 10){
                //System.out.println("Incorrect Format: Incorrect Length, Try Again");



                    throw new InputMismatchException("Incorrect Format: Incorrect Length, Try Again");
                    //valid = false;
                    //break;




            }else {
                valid = true;
                //check digits/dashes
                for (int i = 0; i < 10; i++) {
                    if (i == 4 || i == 7) {
                        if (input.charAt(i) != '-') {
                            valid = false;
                            //System.out.println("Incorrect Format: Incorrect Dashes, Try Again");

                                throw new InputMismatchException("Incorrect Format: Incorrect Dashes");



                        } else {
                            valid = true;
                        }
                    } else {

                        if (Character.isDigit(input.charAt(i)) == false) {
                            valid = false;
                            //System.out.println("Incorrect Format: Incorrect Numbers, Try Again");
                            try{
                                throw new InputMismatchException("Incorrect Format: Please Enter Numbers");
                            }catch(InputMismatchException e){
                                System.out.println("Incorrect Format: Please Enter Numbers");
                                break;
                            }



                        } else {
                            if (input.charAt(5) == '1' && input.charAt(6) > '2') {
                                valid = false;

                            } else {
                                if (input.charAt(8) > '3') {
                                    valid = false;
                                    break;
                                } else if (input.charAt(8) == '3' && input.charAt(9) > '1') {
                                    valid = false;
                                    break;
                                } else {
                                    valid = true;
                                    this.due = input;
                                    break;
                                }

                            }

                        }
                    }
                }
                if (input.charAt(5) == '1' && input.charAt(6) > '2') {

                    System.out.println("Please enter a valid month (1-12).\n");
                } else if (input.charAt(8) == '3' && input.charAt(9) > '1') {
                    System.out.println("Please enter a valid day (1-31).\n");

                }
            }

        }while(!valid);

        return valid;

        /*
        if(input.length() < 1){
            System.out.println("WARNING: due date must be at least 1 character long; task not created");
            return 0;
        }else{
            this.due = input;
            return 1;
        }
         */
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    public void setDue2(String due){
        this.due = due;
    }

    public void setTitle2(String title){
        this.title = title;
    }

    public void setDesc2(String desc){
        this.desc = desc;
    }

    public boolean getCompleted(){
        return completed;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDue() {
        return due;
    }

    @Override
    public String toString(){
        if(this.completed == true){
            return "*** [" + this.due + "] " + this.title + ": " + this.desc;
        }else{
            return "[" + this.due + "] " + this.title + ": " + this.desc;
        }

    }
}
