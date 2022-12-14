import calculator.Calculate;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCalculate {

    @Test
    public void AddTest(){
        Calculate calculate = new Calculate("Add", 4, 5);
        assertEquals(9, calculate.execute());
    }

    @Test
    public void TestSubtract(){
        Calculate calculate = new Calculate("Subtract" , 6, 7);
        assertEquals(-1, calculate.execute());
    }

    @Test
    public void TestMultiply(){
        Calculate calculate = new Calculate("Multiply" , 6, 7);
        assertEquals(42, calculate.execute());
    }
}
