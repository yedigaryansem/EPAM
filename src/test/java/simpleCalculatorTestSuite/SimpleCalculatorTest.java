package simpleCalculatorTestSuite;

import calculator.SimpleCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleCalculatorTest {

    @Test
    public void sumTest() throws IllegalArgumentException{

        int testValue1 = 15;
        int testValue2 = 5;
        int actualValue = SimpleCalculator.sum(testValue1, testValue2);

        int expectedValue = 20;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void divTest() throws ArithmeticException{

        float testValue1 = 15;
        float testValue2 = 5;
        float actualValue = SimpleCalculator.div(testValue1, testValue2);

        float expectedValue = 3;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void subTest() throws IllegalArgumentException{

        int testValue1 = 15;
        int testValue2 = 5;
        int actualValue = SimpleCalculator.sub(testValue1, testValue2);

        int expectedValue = 10;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test()
    public void mulTest() throws IllegalArgumentException{

        int testValue1 = 4;
        int testValue2 = 5;
        int actualValue = SimpleCalculator.mul(testValue1, testValue2);

        int expectedValue = 20;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divExceptionTest() throws ArithmeticException{

        float testValue1 = 5;
        float testValue2 = 0;
        float actualValue = SimpleCalculator.div(testValue1, testValue2);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void mulExceptionTest() throws IllegalArgumentException{

        int testValue1 = Integer.MAX_VALUE - 1; // Integer's maximum value is 2147483647 .
        int testValue2 = 2;
        int actualValue = SimpleCalculator.mul(testValue1, testValue2);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void sumExceptionTest() throws IllegalArgumentException{

        int testValue1 = Integer.MAX_VALUE - 1; // Integer's maximum value is 2147483647 .
        int testValue2 = Integer.MAX_VALUE - 1;
        int actualValue = SimpleCalculator.sum(testValue1, testValue2);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void subExceptionTest() throws IllegalArgumentException{

        int testValue1 = Integer.MIN_VALUE + 1; // Integer's minimum value is -2147483648 .
        int testValue2 = Integer.MAX_VALUE;     // Integer's maximum value is 2147483647 .
        int actualValue = SimpleCalculator.sub(testValue1, testValue2);

    }

}