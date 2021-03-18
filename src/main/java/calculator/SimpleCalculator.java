package calculator;

import java.io.IOException;
import java.security.InvalidParameterException;

public class SimpleCalculator {

    public static int sum(int a, int b) throws Exception {

        long notIntChecker = ((long) a) + ((long) b);
        if (notIntChecker > Integer.MAX_VALUE) {
            throw new InvalidParameterException("The Argument's value bigger than maximum integer value");
        }

        return a + b;
    }

    public static int sub(int a, int b) throws Exception {

        long notIntChecker = ((long) a) - ((long) b);
        if (notIntChecker < Integer.MIN_VALUE) {
            throw new InvalidParameterException("The Argument's value bigger than maximum integer value");
        }

        return a - b;
    }

    public static int mul(int a, int b) throws Exception {

        long notIntChecker = ((long) a) + ((long) b);
        if (notIntChecker > Integer.MAX_VALUE) {
            throw new InvalidParameterException("The Argument's value bigger than maximum integer value");
        }

        return a * b;
    }

    public static float div(float a, float b) throws Exception {
        if (b == 0) {
            throw new InvalidParameterException("Undefined Argument");
        }

        return a / b;
    }


}
