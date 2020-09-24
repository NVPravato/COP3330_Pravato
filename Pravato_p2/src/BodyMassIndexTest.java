import java.util.Scanner;

public class BodyMassIndexTest {


    public static void main(String[] args){
        //test constructor creation
        Scanner scan = new Scanner(System.in);
        double height = scan.nextDouble();
        double weight = scan.nextDouble();
        BodyMassIndex tester = new BodyMassIndex(height, weight);

        //test bmi calculation and category calculation
        System.out.println("Height = " + height + " Weight = " + weight + " BMI: " + tester.calcBmi(height, weight) + " " + tester.calcCat(height, weight) + "\n");

        //test each category
        double heightUnder = 89;
        double weightUnder = 200; //should print bmi of 17.8 and underweight

        double heightNormal = 67;
        double weightNormal = 152; //should print bmi of 23.8 and normal weight

        double heightOver = 72;
        double weightOver = 184; //should print bmi of 25.0 and overweight

        double heightObese= 74;
        double weightObese = 305; //should print bmi of 39.2 and obese

        BodyMassIndex testerUnder = new BodyMassIndex(heightUnder, weightUnder);
        BodyMassIndex testerNormal = new BodyMassIndex(heightNormal, weightNormal);
        BodyMassIndex testerOver = new BodyMassIndex(heightOver, weightOver);
        BodyMassIndex testerObese = new BodyMassIndex(heightObese, weightObese);

        System.out.println("Height = " + heightUnder + " Weight = " + weightUnder + " BMI: " + tester.calcBmi(heightUnder, weightUnder) + " " + tester.calcCat(heightUnder, weightUnder));

        System.out.println("Height = " + heightNormal + " Weight = " + weightNormal + " BMI: " + tester.calcBmi(heightNormal, weightNormal) + " " + tester.calcCat(heightNormal, weightNormal));

        System.out.println("Height = " + heightOver + " Weight = " + weightOver + " BMI: " + tester.calcBmi(heightOver, weightOver) + " " + tester.calcCat(heightOver, weightOver));

        System.out.println("Height = " + heightObese + " Weight = " + weightObese + " BMI: " + tester.calcBmi(heightObese, weightObese) + " " + tester.calcCat(heightObese, weightObese));



    }

}
