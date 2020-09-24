import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    private BodyMassIndex tester;


    @BeforeEach
    public void init(){
        //BodyMassIndex tester = new BodyMassIndex(10, 20);
    }



    @Test
    void calcBmi() {
        tester = new BodyMassIndex(67, 152);
        double calc = Math.round(tester.calcBmi(67, 152)*10.0)/10.0;
        assertEquals(calc, 23.8);
    }

    @Test
    void calcCatUnder() {
        tester = new BodyMassIndex(89, 200);
        String cat = tester.calcCat(89, 200);
        assertEquals(cat, " (Underweight)");
    }

    @Test
    void calcCatNormal() {
        tester = new BodyMassIndex(67, 152);
        String cat = tester.calcCat(67, 152);
        assertEquals(cat, " (Normal Weight)");
    }

    @Test
    void calcCatOver() {
        tester = new BodyMassIndex(72, 184);
        String cat = tester.calcCat(72, 184);
        assertEquals(cat, " (Overweight)");
    }

    @Test
    void calcCatObese() {
        tester = new BodyMassIndex(74, 305);
        String cat = tester.calcCat(74, 305);
        assertEquals(cat, " (Obese)");
    }

    @Test
    void getH(){
        tester = new BodyMassIndex(67, 152);
        assertEquals(tester.getHeight(), 67);
    }

    @Test
    void getW(){
        tester = new BodyMassIndex(67, 152);
        assertEquals(tester.getWeight(), 152);
    }

    @Test
    void getB(){
        tester = new BodyMassIndex(67, 152);
        assertEquals(tester.getBmi(), 23.80396524838494);
    }

    @Test
    void getBR(){
        tester = new BodyMassIndex(67, 152);
        assertEquals(tester.getBmi(), 23.8);
    }
}