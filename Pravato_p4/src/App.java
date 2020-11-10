import java.util.*;
import java.io.*;
import java.nio.*;

public class App {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int selection = 0;
        int selLOMenu = 0;
        int selCTMenu = 0;

        do{


            System.out.println("Main Menu\n--------\n");
            System.out.println("1) create a new list\n2) load an existing list\n3) quit");
            try{
                selection = scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println(e);
            }

            if(selection == 1){
                TaskList list = new TaskList();
                System.out.println("new task list has been created\n");
                do{
                    System.out.println("List Operation Menu\n--------\n");
                    System.out.println("1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu");
                    try {

                        selLOMenu = scan.nextInt();

                    }catch(InputMismatchException e){
                        System.out.println("Please enter a valid number");
                    }

                    switch(selLOMenu){
                        case 1:
                            list.viewList();
                            ;

                        case 2:
                            list.addItem();
                            ;

                        case 3:
                            list.editItem();
                            ;

                        case 4:
                            list.removeItem();
                            ;

                        case 5:
                            list.complete();
                            ;

                        case 6:
                            list.uncomplete();
                            ;

                        case 7:

                            ;

                        case 8:

                        ;

                        default:
                            throw new InputMismatchException("Please choose a valid option");

                    }

                }while(selLOMenu != 8);




            }else if(selection == 2){
                System.out.println("Which list do you want to load?");
                //



                //

            }else if(selection != 3 && selection != 1 && selection != 2){
                System.out.println("Please Choose 1, 2, or 3");
            }

        }while(selection != 3);

    }
    /*
    public static TaskList newList(){
        TaskList list = new TaskList();
        return list;
    }
    */

    public static void temp(){

    }


}