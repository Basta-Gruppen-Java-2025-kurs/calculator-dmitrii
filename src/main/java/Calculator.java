import java.util.List;

public class Calculator {
    public int add(int a, int b) {
        long result = ((long) a) + b;
        if(result > Integer.MAX_VALUE) {
            throw new AdditionOverflowException("Addition result above maximum integer");
        }
        return a + b;
    }

    public int subtract(int a, int b) {
        long result = ((long) a) - b;
        if(result < Integer.MIN_VALUE) {
            throw new SubtractionUnderflowException("Subtraction result below minimum integer");
        }
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int num, int den) {
        if (den == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return num / den;
    }

    public int abs(int x) {
        if (x == Integer.MIN_VALUE) {
            throw new NoAbsoluteValueException("Cannot get absolute value of the minimum int");
        }
        return Math.abs(x);
    }

    public boolean isEven(int x) {
        return (x % 2 == 0);
    }

    public int max(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElseThrow(IllegalArgumentException::new);
    }


}
