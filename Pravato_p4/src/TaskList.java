import java.util.*;
import java.io.*;
import java.nio.*;

public class TaskList implements Serializable {
    private static ArrayList<TaskItem> ti = new ArrayList<TaskItem>();


    public TaskList(){

    }

    public static void addTask(TaskItem task){

        ti.add(task);

    }

    public static void removeTask(TaskItem task){

        ti.remove(task);

    }


    public static void viewList(){
        System.out.println("Current Tasks\n-----------");

        for(int i = 0; i < ti.size(); i++){
            System.out.println(i + ") " + ti.get(i).toString());
        }

    }

    public static void viewComp(){
        System.out.println("Current Completed Tasks\n-----------");

        for(int i = 0; i < ti.size(); i++){
            if(ti.get(i).getCompleted() == true){
                System.out.println(i + ") " + ti.get(i).toString());
            }
        }
    }

    public static void viewUncomp(){
        System.out.println("Current Uncompleted Tasks\n-----------");

        for(int i = 0; i < ti.size(); i++){
            if(ti.get(i).getCompleted() == false){
                System.out.println(i + ") " + ti.get(i).toString());
            }

        }
    }


    public static void addItem(){
        TaskItem temp = new TaskItem();
        //String user = userIn();

        temp.setTitle();
        temp.setDesc();
        temp.setDue();
        ti.add(temp);
        System.out.println("Task Created.");
    }

    public static void setEditItem(int index){
        TaskItem temp = new TaskItem();
        //String user = userIn();

        temp.setTitle();
        temp.setDesc();
        temp.setDue();

        ti.set(index, temp);
        System.out.println("Task " + index + " changed.");
    }

    /*
    private static String userIn(){

        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        return user;
    }
    */

    public static void editItem(){
        Scanner scan = new Scanner(System.in);
        viewList();
        System.out.println("Which task do you want to edit? (enter number):");
        int edit = 0;
        try{
            edit = scan.nextInt();

        }catch(InputMismatchException e){
            System.out.println(e);
        }

        setEditItem(edit);


    }



    public static void removeItem(){
        Scanner scan = new Scanner(System.in);
        viewList();
        System.out.println("Which task do you want to remove? (enter number):");
        int remove = 0;
        try{
            remove = scan.nextInt();

        }catch(InputMismatchException e){
            System.out.println(e);
        }

        ti.remove(remove);
    }


    public static void complete(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which task do you want to complete? (enter number)");
        viewUncomp();
        int index = 0;
        try{
            index = scan.nextInt();

        }catch(InputMismatchException e){
            System.out.println(e);
        }
        ti.get(index).setCompleted(true);
    }

    public static void uncomplete(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which task do you want to un-complete? (enter number)");
        viewComp();
        int index = 0;
        try{
            index = scan.nextInt();

        }catch(InputMismatchException e){
            System.out.println(e);
        }
        ti.get(index).setCompleted(false);
    }
}
