package calculator;

import java.security.InvalidParameterException;

public class SimpleCalculator {

    public static int sum(int a, int b) throws InvalidParameterException {

        long IntOverflowChecker = (long) a + (long) b;
        if (IntOverflowChecker > Integer.MAX_VALUE) {
            throw new InvalidParameterException("The Argument's value bigger than maximum integer value");
        }

        return a + b;
    }

    public static int sub(int a, int b) throws InvalidParameterException {

        long IntOverflowChecker = (long) a - (long) b;
        if (IntOverflowChecker < Integer.MIN_VALUE) {
            throw new InvalidParameterException("The Argument's value bigger than maximum integer value");
        }

        return a - b;
    }

    public static int mul(int a, int b) throws InvalidParameterException {

        long IntOverflowChecker = (long) a + (long) b;
        if (IntOverflowChecker > Integer.MAX_VALUE) {
            throw new InvalidParameterException("The Argument's value bigger than maximum integer value");
        }

        return a * b;
    }

    public static float div(float a, float b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("It is illegal to divide to 0");
        }

        return a / b;
    }

}