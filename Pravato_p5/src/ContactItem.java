import java.util.InputMismatchException;

public class ContactItem {
    private String fname;
    private String lname;
    private String phone;
    private String email;
    private int numItems;

    public ContactItem(){
        fname = "";
        lname = "";
        phone = "";
        email = "";
    }

    //getters
    public String getFname(){
        return this.fname;
    }

    public String getLname(){
        return this.lname;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getEmail(){
        return this.email;
    }

    public int getNumItems(){
        return this.numItems;
    }


    //setters
    public void setFname(String input) throws InputMismatchException {
        if(input.length() >= 1){
            this.numItems ++;
        }
        if(this.numItems != 0 && input == ""){
            this.numItems --;
        }
        this.fname = input;
    }

    public void setLname(String input){
        if(input == ""){

        }else if(input.length() >= 1){
            this.numItems ++;
        }
        if(this.numItems != 0 && input == ""){
            this.numItems --;
        }
        this.lname = input;
    }

    public void setPhone(String input) throws InputMismatchException, IndexOutOfBoundsException{
        boolean valid = true;
        if(input == ""){

        }else if(input.length() >= 1){
            for(int i = 0; i < 12; i++){
                if(i == 3 || i == 7){
                    if(input.charAt(i) != '-'){
                        valid = false;
                    }
                }else{
                    if(Character.isDigit(input.charAt(i)) == false){
                        valid = false;
                    }
                }

            }

            if(valid == true){
                this.phone = input;
            }else{
                throw new InputMismatchException("Error: Invalid Phone Number Format (xxx-xxx-xxxx)");
            }
            this.numItems ++;
        }
        if(this.numItems != 0 && input == ""){
            this.numItems --;
        }


    }

    public void setEmail(String input) throws InputMismatchException, IndexOutOfBoundsException{

        if(input == ""){

        }else if(input.length() >= 1){
            //System.out.println("added");
            int atIndex = -1;
            int dotIndex = -1;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == '@'){
                    atIndex = i;
                }
                if(input.charAt(i) == '.'){
                    dotIndex = i;
                }
            }

            if(dotIndex == (input.length() - 1)){
                throw new IndexOutOfBoundsException("Error: Incorrect Email Format (x@y.z) --> (Missing z)");
            }else if(atIndex == (input.length() - 1)){
                throw new IndexOutOfBoundsException("Error: Incorrect Email Format (x@y.z) --> (Missing y and z)");
            }else if(atIndex == -1){
                throw new IndexOutOfBoundsException("Error: Incorrect Email Format (x@y.z) --> (Missing @ Symbol)");
            }else if(dotIndex == -1){
                throw new IndexOutOfBoundsException("Error: Incorrect Email Format (x@y.z) --> (Missing . Symbol)");
            }else if(dotIndex == (atIndex + 1)){
                throw new IndexOutOfBoundsException("Error: Incorrect Email Format (x@y.z) --> (Missing y)");
            }else if(atIndex == 0){
                throw new IndexOutOfBoundsException("Error: Incorrect Email Format (x@y.z) --> (Missing x)");
            }else if(dotIndex == 0){
                throw new IndexOutOfBoundsException("Error: Incorrect Email Format (x@y.z) --> (Missing x and y)");
            }else if(atIndex > dotIndex){
                throw new IndexOutOfBoundsException("Error: Incorrect Email Format (x@y.z)");
            }

                this.numItems ++;
        }
        if(this.numItems != 0 && input == ""){
            this.numItems --;
        }
        if(numItems < 1){
            throw new InputMismatchException("Warning: Contact Item must contain at least one item");
        }
        this.email = input;

    }

    public void setPhone2(String input){
        this.phone = input;
    }

    public void setEmail2(String input){
        this.email = input;
    }


    /*
    public int setNumItems(int input){
        return this.numItems;
    }
     */

    //this is for the tear down in junit testing
    public void clear(){
        this.fname = "";
        this.lname = "";
        this.phone = "";
        this.email = "";
        this.numItems = 0;
    }

    @Override
    public String toString(){
        String total = "Name: ";
        if(this.fname.length() >= 1){
            total += this.fname;
        //}else if(this.lname.length() < 1){
            //total += "N/A";
        }else{
            total += "N/A";
        }
        if(this.lname.length() >= 1){
            total += (" " + this.lname);
        }

        total += "\nPhone: ";

        if(this.phone.length() == 12){
            total += this.phone;
        }else{
            total += "N/A";
        }

        total += "\nEmail: ";

        if(this.email.length() >= 1){
            total += this.email;
        }else{
            total += "N/A";
        }
        //return "Name: " + this.fname + " " + this.lname + "\nPhone: " + this.phone + "\nEmail: " + this.email + " num:" + numItems;
        return total;

    }

}
