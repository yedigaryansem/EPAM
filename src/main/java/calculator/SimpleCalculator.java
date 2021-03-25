package calculator;

public class SimpleCalculator {

    public static int sum(int a, int b) throws ArithmeticException {
        //Overflow iff both arguments have the opposite sign of the result

        int res = a + b;

        if (((a ^ res) & (b ^ res)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return res;
    }

    public static int sub(int a, int b) throws ArithmeticException {
        // Overflow iff the arguments have different signs and
        // the sign of the result is different from the sign of a

        int res = a - b;

        if (((a ^ b) & (a ^ res)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return res;
    }

    public static int mul(int a, int b) throws ArithmeticException {

        long res = (long)a * (long)b;
        if ((int)res != res) {
            throw new ArithmeticException("integer overflow");
        }
        return (int)res;
    }

    public static float div(float a, float b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("It is illegal to divide to 0");
        }

        return a / b;
    }

}