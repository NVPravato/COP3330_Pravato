import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class TaskList {

    private static ArrayList<TaskItem> ti = new ArrayList<TaskItem>();


    public TaskList() {

    }


    public static void viewList() {
        System.out.println("Current Tasks\n-----------");

        for (int i = 0; i < ti.size(); i++) {
            System.out.println(i + ") " + ti.get(i).toString());
        }

    }

    public static void viewComp() {
        System.out.println("Current Completed Tasks\n-----------");

        for (int i = 0; i < ti.size(); i++) {
            if (ti.get(i).getCompleted() == true) {
                System.out.println(i + ") " + ti.get(i).toString());
            }
        }
    }

    public static void viewUncomp() {
        System.out.println("Current Uncompleted Tasks\n-----------");

        for (int i = 0; i < ti.size(); i++) {
            if (ti.get(i).getCompleted() == false) {
                System.out.println(i + ") " + ti.get(i).toString());
            }

        }
    }


    public static void addItem(String itemT, String itemDesc, String itemDue) {
        TaskItem temp = new TaskItem();
        //String user = userIn();
        boolean valid = true;
        //valid = temp.setTitle();
        //temp.setTitle();
        //temp.setDesc();
        //valid = temp.setDue();
        //temp.setDue();

        boolean validT = false;
        boolean validDesc = false;
        boolean validDue = false;
        try{
            validT = temp.setTitle(itemT);
            if(validT){
                validDesc = temp.setDesc(itemDesc);
                validDue = temp.setDue(itemDue);
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }






        if(validT && validDesc && validDue){
            ti.add(temp);
            System.out.println("Task Created.");
        }else{
            System.out.println("Error: Task not created");
        }
    }

    public static void setEditItem(int index, String itemT, String itemDesc, String itemDue) {
        TaskItem temp = new TaskItem();
        //String user = userIn();
        boolean validT = false;
        boolean validDesc = false;
        boolean validDue = false;

        try{
            validT = temp.setTitle(itemT);
            if(validT){
                validDesc = temp.setDesc(itemDesc);
                validDue = temp.setDue(itemDue);
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }


        if(validT && validDesc && validDue){
            ti.set(index, temp);
            System.out.println("Task " + index + " changed.");
        }else{
            System.out.println("Error: Task not changed");
        }


    }

    /*
    private static String userIn(){

        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        return user;
    }
    */




    public static void removeItem(int index) throws IndexOutOfBoundsException {

            ti.remove(index);

    }


    public static void complete(int index) throws IndexOutOfBoundsException{
        //Scanner scan = new Scanner(System.in);

        if (ti.get(index).getCompleted() != false) {
            throw new IndexOutOfBoundsException();
        }

            ti.get(index).setCompleted(true);






    }

    public static void uncomplete(int index) throws IndexOutOfBoundsException,  InputMismatchException{

        if (ti.get(index).getCompleted() != true) {

            throw new InputMismatchException();

        }

        ti.get(index).setCompleted(false);

    }


    public static void AccessSaveFile(String fileName) throws IOException{
        saveFile(fileName);
    }

    private static void saveFile(String fileName) throws IOException{
        PrintWriter write = new PrintWriter(new File(fileName));
        for (TaskItem item : ti) {
            write.println(item.toString());
        }
        write.close();

        System.out.println("Task list has been saved");


        /*
        System.out.println("Enter Directory to Save This List");
        Path path = Paths.get(scan.nextLine());
         */
    }


    public static void readFile(String fileName){
        boolean fileLoaded = false;
        while(fileLoaded == false) {

            try {
                Scanner fin = new Scanner(new File(fileName));
                ti.clear();
                while (fin.hasNextLine()) {
                    String line = fin.nextLine();
                    System.out.println(line);
                    boolean completed = false;
                    if (line.charAt(0) == '*') {
                        completed = true;
                        line = line.substring(4);
                    }
                    String date = line.substring(1, 11);
                    line = line.substring(13);
                    int colonIndex = line.indexOf(':');
                    String title = line.substring(0, colonIndex);
                    String desc = line.substring(colonIndex + 2);

                    TaskItem item = new TaskItem();
                    item.setDue2(date);
                    item.setDesc2(desc);
                    item.setCompleted(completed);
                    item.setTitle2(title);

                    ti.add(item);

                }

                fileLoaded = true;
            } catch (IOException e) {
                System.out.println("An error occurred. File not loaded.");
            }
        }



    }


    public static int getLength(){
        return ti.size();
    }

    public static boolean getEmpty(){
        return ti.isEmpty();
    }

    public static TaskItem getListItem(int index) throws IndexOutOfBoundsException {
        boolean valid = false;
                return ti.get(index);

    }

    public static void clear(){
        ti.clear();
    }
}




