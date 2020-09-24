import java.io.*;
import java.util.*;

public class BodyMassIndex {
    public double bmi;
    public double height;
    public double weight;


    BodyMassIndex(double height, double weight){
        this.height = height;
        this.weight = weight;

        bmi = 703 * this.weight / (this.height * this.height);


    }

    public double calcBmi(double height, double weight){
        double thisBmi = 703 * this.weight / (this.height * this.height);
        return thisBmi;
    }

    public String calcCat(double height, double weight){
        double bmiRounded = Math.round(calcBmi(this.height, this.weight)*10.0)/10.0; //rounds bmi to 1 decimal like in official calculator
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
        String cat = "";
        if(bmiRounded < 18.5){//This is a copy/paste of the commented code above, except it's rounded now
            cat = " (Underweight)";
        }else if(bmiRounded >= 18.5 && bmiRounded <= 24.9){
            cat = " (Normal Weight)";
        }else if(bmiRounded >= 25 && bmiRounded <= 29.9){
            cat = " (Overweight)";
        }else if(bmiRounded >= 30){
            cat = " (Obese)";
        }
        return cat;
    }

    /*
    public double getHeight(){
        return height;
    }


    public double getWeight(){
        return weight;
    }

    public double getBmi(){
        return bmi;
    }
     */
}
