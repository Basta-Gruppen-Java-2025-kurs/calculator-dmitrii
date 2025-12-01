import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void addTest() {
        assertEquals(5, calculator.add(2,3));
    }

    @Test
    public void subtractTest() {
        assertEquals(7, calculator.subtract(10, 3));
        assertEquals(-7, calculator.subtract(3, 10));
    }

    @Test
    public void multiplyTest() {
        assertEquals(0, calculator.multiply(0, 10));
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    public void divisionTest() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    public void divideThrowsZeroDivisionException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    public void absTest() {
        assertEquals(5, calculator.abs(-5));
        assertEquals(5, calculator.abs(5));
    }

    @Test
    public void isEvenTest() {
        assertTrue(calculator.isEven(4));
        assertFalse(calculator.isEven(5));
    }

    @Test
    public void maxTest() {
        List<Integer> testList = List.of(1,5,3);
        assertEquals(5, calculator.max(testList));
    }

    @Test
    public void maxThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.max(List.of()));
    }

    @Test
    public void addThrowsOverflowException() {
        assertThrows(AdditionOverflowException.class, () -> calculator.add(Integer.MAX_VALUE, 1));
    }

    @Test
    public void subtractThrowsUnderflowException() {
        assertThrows(SubtractionUnderflowException.class, () -> calculator.subtract(Integer.MIN_VALUE, 1));
    }

    @Test
    public void multiplyNegatives() {
        assertEquals(-10, calculator.multiply(-2, 5));
        assertEquals(4, calculator.multiply(-2, -2));
    }

    @Test
    public void divideNegatives() {
        assertEquals(-5, calculator.divide(-10, 2));
        assertEquals(5, calculator.divide(-10, -2));
    }

    @Test
    public void absThrowsNoAbsoluteValueException() {
        assertThrows(NoAbsoluteValueException.class, () -> calculator.abs(Integer.MIN_VALUE));
    }

    @Test
    public void maxOfEquals() {
        assertEquals(4, calculator.max(List.of(4, 4, 4, 4)));
    }

    @Test
    public void maxOfNegatives() {
        assertEquals(-3, calculator.max(List.of(-10, -3, -50)));
    }

    @Test
    public void maxOfALot() {
        Random rand = new Random();
        // arrange
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            integers.add(rand.nextInt(100));
        }
        integers.set(rand.nextInt(10000), 200);

        // act
        int result = calculator.max(integers);
        //assert
        assertEquals(200, result);
    }

    @Test
    public void isEvenOfMaxValue() {
        assertFalse(calculator.isEven(Integer.MAX_VALUE));
        assertTrue(calculator.isEven(Integer.MIN_VALUE));
    }

}
