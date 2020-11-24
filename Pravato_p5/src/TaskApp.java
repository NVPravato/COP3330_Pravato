import java.util.*;
import java.io.*;
import java.nio.*;

public class TaskApp {
    /*
    public static void badFunction() throws CustomException {
        if(1 < 2) {
            throw new CustomException("Just a test");
        }
    }
     */

    public static void main(String[] args){
        /*
        try {
            badFunction();
            System.out.println("Bad function finished successfully");
        }
        catch(Exception ex) {
            //ex.printStackTrace();
            System.out.println("Bad function prevented");
        }
        */

        Scanner scan = new Scanner(System.in);
        TaskList list = new TaskList();

        boolean quitting = false;
        while(quitting == false) {

            boolean loading = true;
            while(loading == true) {
                mainMenu();

                int selection = selOption(1, 3);
                switch (selection) {

                    case 1:
                        list = newList();
                        loading = false;
                        break;
                    case 2:

                        System.out.println("Enter the filename to load: ");
                        String fileName = scan.nextLine();
                        list.readFile(fileName);
                        System.out.println("Task list loaded.");
                        loading = false;
                        break;
                    case 3:
                        System.out.println("Quitting");
                        quitting = true;
                        loading = false;
                        break;
                    default:
                        System.out.println("Invalid selection return from selMain, this should never happen");
                        break;
                }
            }

            if(quitting == false) {
                System.out.println("Task list has been loaded/created");

                boolean workingOnList = true;
                while(workingOnList == true) {
                    listMenu();
                    boolean valid = false;
                    int index = 0;
                    int selection = selOption(1, 8);
                    switch (selection) {

                        case 1:
                            list.viewList();
                            break;
                        case 2:
                            System.out.println("Task title: ");
                            String itemT = scan.nextLine();
                            System.out.println("Task description: ");
                            String itemDesc = scan.nextLine();
                            System.out.println("Task due date (YYYY-MM-DD): ");
                            String itemDue = scan.nextLine();
                            list.addItem(itemT, itemDesc, itemDue);

                            break;
                        case 3:
                            list.viewList();
                            System.out.println("Which task do you want to edit? (enter number):");
                            int edit = 0;
                            valid = false;
                            while(!valid){
                                try {
                                    edit = scan.nextInt();
                                    scan.nextLine();
                                    if(index == -1){
                                        valid = true;
                                        listMenu();
                                    }else{
                                        System.out.println("Task title: ");
                                        String itemET = scan.nextLine();
                                        System.out.println("Task description: ");
                                        String itemEDesc = scan.nextLine();
                                        System.out.println("Task due date (YYYY-MM-DD): ");
                                        String itemEDue = scan.nextLine();
                                        list.setEditItem(edit, itemET, itemEDesc, itemEDue);
                                    }
                                    valid = true;

                                } catch (InputMismatchException e) {
                                    System.out.println("Please enter a valid number.\n");

                                } catch (ArrayIndexOutOfBoundsException e) {
                                    System.out.println("Please enter a valid number.\n");

                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("Please enter a valid number.\n");

                                }


                            }
                            break;
                        case 4:

                            list.viewList();
                            System.out.println("Which task do you want to remove? (enter number):");
                            int remove = 0;
                            try {
                                remove = scan.nextInt();
                                scan.nextLine();
                                if(index == -1){
                                    valid = true;
                                    listMenu();
                                }else{
                                    list.removeItem(remove);
                                }
                                valid = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter a valid number.\n");

                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Please enter a valid number.\n");

                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Please enter a valid number.\n");

                            }
                            break;
                        case 5:
                            System.out.println("Which task do you want to complete? (enter number) or enter -1 to cancel");
                            list.viewUncomp();
                            index = 0;
                            valid = false;

                            while(!valid){
                                try {
                                    index = scan.nextInt();
                                    scan.nextLine();
                                    if(index == -1){
                                        valid = true;
                                        listMenu();
                                    }
                                    valid = true;

                                } catch (InputMismatchException e) {
                                    System.out.println("Please enter a valid number.\n");

                                }

                            }



                            try{
                                list.complete(index);
                            }catch(ArrayIndexOutOfBoundsException e){
                                System.out.println("Error: Invalid Index: Please enter a valid number.\n");
                            }catch(IndexOutOfBoundsException e){
                                System.out.println("Error: Invalid Index: Please enter a valid number.\n");
                            }

                            break;
                        case 6:
                            System.out.println("Which task do you want to un-complete? (enter number) or enter -1 to cancel");
                            list.viewComp();
                            valid = false;
                            index = 0;
                            while(!valid){
                                try {
                                    index = scan.nextInt();
                                    scan.nextLine();
                                    if(index == -1){
                                        valid = true;
                                        listMenu();
                                    }
                                    list.uncomplete(index);
                                    valid = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("Please enter a valid number.\n");

                                } catch (ArrayIndexOutOfBoundsException e) {
                                    System.out.println("Please enter a valid number.\n");

                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("Please enter a valid number.\n");

                                }

                            }

                            break;
                        case 7:

                            try{
                                System.out.println("Enter the filename to save as:");
                                String fileName = scan.nextLine();
                                System.out.println("Saving File...");
                                list.AccessSaveFile(fileName);
                            }catch(IOException e){
                                System.out.println("File cannot be saved.");
                            }
                            break;
                        case 8:
                            System.out.println("Returning to main menu");
                            workingOnList = false;
                            break;
                        default:
                            System.out.println("Invalid choice returned, this should never happen");
                            break;
                    }
                }
            }
        }
    }

    public static void mainMenu(){
        System.out.println("\nMain Menu\n--------");
        System.out.println("1) Create a new list\n2) Load an existing list\n3) Quit");
    }

    public static int selOption(int min, int max){
        Scanner scan = new Scanner(System.in);
        int selection = 0;
        while(selection < min || selection > max) {
            try {
                selection = scan.nextInt();
                scan.nextLine();
                if(selection < min || selection > max) {
                    System.out.println("Valid options are from " + min + " to " + max);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
            }
        }

        return selection;
    }


    public static TaskList newList(){

        TaskList list = new TaskList();
        System.out.println("Task list has been created.");
        return list;

    }


    public static void listMenu(){

        System.out.println("\nList Operation Menu\n--------");
        System.out.println("1) View the list\n2) Add an item\n3) Edit an item\n4) Remove an item\n5) Mark an item as completed\n6) Unmark an item as completed\n7) Save the current list\n8) Quit to the main menu");

    }



}