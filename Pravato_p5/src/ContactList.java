import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class ContactList {

    private static ArrayList<ContactItem> ti = new ArrayList<ContactItem>();


    public ContactList() {

    }


    public static void viewList() {
        System.out.println("Current Contacts\n-----------");

        for (int i = 0; i < ti.size(); i++) {
            System.out.println(i + ") " + ti.get(i).toString());
        }

    }




    public static void addItem(String fname, String lname, String phone, String email) throws InputMismatchException{
        ContactItem temp = new ContactItem();
        boolean valid = false;
        //try{
            temp.setFname(fname);
            temp.setLname(lname);
            temp.setPhone(phone);
            temp.setEmail(email);
            valid = true;
        //}catch(InputMismatchException e){
            //e.printStackTrace();
        //}catch(IndexOutOfBoundsException e){
            //e.printStackTrace();
            //System.out.println("Incorrect Format");
        //}






        if(valid){
            ti.add(temp);
            System.out.println("Contact Created.");
        }else{
            System.out.println("Error: Contact not created");
        }

    }

    public static void setEditItem(int index, String fname, String lname, String phone, String email) throws InputMismatchException {
        ContactItem temp = new ContactItem();
        //String user = userIn();
        //boolean validT = false;
        //boolean validDesc = false;
        //boolean validDue = false;
        boolean valid = false;

        //try{
            temp.setFname(fname);
            temp.setLname(lname);
            temp.setPhone(phone);
            temp.setEmail(email);
            valid = true;
        //}catch(InputMismatchException e){
            //e.printStackTrace();
        //}


        if(valid){
            ti.set(index, temp);
            System.out.println("Contact " + index + " changed.");
        }else{
            System.out.println("Error: Contact not changed");
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






    public static void AccessSaveFile(String fileName) throws IOException{
        saveFile(fileName);
    }

    private static void saveFile(String fileName) throws IOException{
        PrintWriter write = new PrintWriter(new File(fileName));
        for (ContactItem item : ti) {
            write.println(item.toString());
        }
        write.close();

        System.out.println("Contact list has been saved");


        /*
        System.out.println("Enter Directory to Save This List");
        Path path = Paths.get(scan.nextLine());
         */
    }

    /* come back to this soon
    */
    public static void readFile(String fileName){
        boolean fileLoaded = false;
        //System.out.println("here-2");
        while(fileLoaded == false) {
            //System.out.println("here-1");
            try {
                Scanner fin = new Scanner(new File(fileName));
                //System.out.println("here0");
                ti.clear();
                while (fin.hasNextLine()) {
                    //System.out.println("here1");
                    String line = fin.nextLine();
                    //System.out.println("here2");
                    //System.out.println(line);
                    int fnameEnd = 0;
                    for(int i = 0; i < line.length(); i++){
                        if(line.charAt(i) == ' '){
                            fnameEnd = i;
                            //System.out.println("here3");
                        }
                    }
                    //System.out.println("here4");
                    String fname = line.substring(6, fnameEnd);
                    line = line.substring(fnameEnd + 1);
                    //System.out.println("here5");
                    String lname = line;
                    line = fin.nextLine();
                    //System.out.println(line);
                    String phone = line.substring(7, line.length());
                    line = fin.nextLine();
                    //System.out.println(line);
                    String email = line.substring(7, line.length());

                    ContactItem item = new ContactItem();
                    item.setFname(fname);
                    item.setLname(lname);
                    item.setPhone2(phone);
                    item.setEmail2(email);

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

    public static ContactItem getListItem(int index) throws IndexOutOfBoundsException {
        boolean valid = false;
        return ti.get(index);

    }

    public static void clear(){
        ti.clear();
    }
}




