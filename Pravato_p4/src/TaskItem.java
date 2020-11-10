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
        setTitle();
        setDesc();
        setDue();
        /*
        int tValid = setTitle();
        int deValid = setDesc();
        int duValid = setDue();

        if(tValid == deValid && deValid == duValid && duValid == 1){

        }
        */
    }

    public void setTitle() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Task title: ");
        String input = scan.nextLine();

        do{
            if(input.length() < 1){
                System.out.println("WARNING: title must be at least 1 character long; task not created");
            }else{
                this.title = input;
                break;
            }

        }while(input.length() < 1);

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

    public void setDesc() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Task description: ");
        String input = scan.nextLine();

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

    public void setDue() {
        Scanner scan = new Scanner(System.in);
        //make a for loop checking if they are digits, chars @ 2 and 5 should be '-'
        int valid = 1;

        do{
            System.out.println("Task due date (YYYY-MM-DD): ");
            String input = scan.nextLine();

            //check 10 character length
            if(input.length() != 10){
                //System.out.println("Incorrect Format: Incorrect Length, Try Again");
                valid = 0;
                throw new InputMismatchException("Incorrect Format: Incorrect Length, Try Again");

            }else{
                valid = 1;
                //check digits/dashes
                for(int i = 0; i < 10; i++){
                    if(i == 4 || i == 7){
                        if(input.charAt(i) != '-'){
                            valid = 0;
                            //System.out.println("Incorrect Format: Incorrect Dashes, Try Again");
                            throw new InputMismatchException("Incorrect Format: Incorrect Dashes, Try Again");
                        }else{
                            valid = 1;
                        }
                    }else{
                        if(Character.isDigit(input.charAt(i)) == false){
                            valid = 0;
                            //System.out.println("Incorrect Format: Incorrect Numbers, Try Again");
                            throw new InputMismatchException("Incorrect Format: Incorrect Numbers, Try Again");
                        }else{
                            valid = 1;
                            break;
                        }
                    }
                }

            }

        }while(valid == 0);


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
            return "[" + this.due + "] " + this.title + ": " + this.desc;
        }else{
            return "[" + this.due + "] " + this.title + ": " + this.desc;
        }

    }
}
