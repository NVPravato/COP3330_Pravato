import java.io.*;
import java.util.*;

public class App {





    //
    //
    //
    //DO NOT CHANGE//
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    //DO NOT CHANGE//
    //
    //
    //




    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        BodyMassIndex temp;
        //System.out.println(bmiData);
        double total = 0;
        for(int i = 0; i <= bmiData.size() - 1; i++){
            temp = (bmiData.get(i));
            //temp.bmi = (Math.round(temp.bmi*10.0)/10.0);//Rounds before averaging
            //System.out.println(temp.bmi);
            total += temp.getBmiRounded();
            //System.out.println(bmiData.get(i).bmi);
            //total += bmiData.get(i).bmi;

        }
        double average = total/bmiData.size();
        average = Math.round(average * 10.0) / 10.0;
        System.out.println("Average User BMI: " + average);
    }



    public static void displayBmiInfo(BodyMassIndex bmi){

        //System.out.print("BMI: " + (Math.round(bmi.bmi*10.0)/10.0));
        //double bmiRounded = (Math.round(bmi.bmi*10.0)/10.0);
        //^^^ I just realized I'm supposed to do this in a method in BodyMassIndex so I commented this out

        double bmiRounded = (Math.round(bmi.calcBmi(bmi.getHeight(), bmi.getWeight())*10.0)/10.0);
        System.out.print("BMI: " + bmiRounded);
        System.out.println(" " + bmi.calcCat(bmi.getHeight(), bmi.getWeight()));


        /*
        if(bmi.bmi < 18.5){
            System.out.println(" (Underweight)");
        }else if(bmi.bmi >= 18.5 && bmi.bmi <= 24.9){
            System.out.println(" (Normal Weight)");
        }else if(bmi.bmi >= 25 && bmi.bmi <= 29.9){
            System.out.println(" (Overweight)");
        }else if(bmi.bmi >= 30){
            System.out.println(" (Obese)");
        }
         */ //^^ not rounded, causes problems ^^


        /*
        if(bmiRounded < 18.5){//This is a copy/paste of the commented code above, except it's rounded now
            System.out.println(" (Underweight)");
        }else if(bmiRounded >= 18.5 && bmiRounded <= 24.9){
            System.out.println(" (Normal Weight)");
        }else if(bmiRounded >= 25 && bmiRounded <= 29.9){
            System.out.println(" (Overweight)");
        }else if(bmiRounded >= 30){
            System.out.println(" (Obese)");
        }
         */
        //^^^ I just realized I'm supposed to do this in a method in BodyMassIndex so I commented this out

    }



    public static boolean moreInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter New Height/Weight? (Y/N)");
        String answer = scan.nextLine();
        boolean ret = false;
        if(answer.equalsIgnoreCase("y")){
            ret = true;
        }else if(answer.equalsIgnoreCase("n")){
            ret = false;
        }

        return ret;
    }



    public static double getUserHeight(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter User Height (In Inches):");
        double in = scan.nextDouble();
        scan.nextLine();
        if(in < 0){
            System.out.println("ERROR: Please Enter A Valid Height");
            getUserHeight();
        }
        return in;

    }


    
    public static double getUserWeight(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter User Weight (In Pounds):");
        double in = scan.nextDouble();
        scan.nextLine();
        if(in < 0){
            System.out.println("ERROR: Please Enter A Valid Weight");
            getUserWeight();
        }
        return in;

    }


}
