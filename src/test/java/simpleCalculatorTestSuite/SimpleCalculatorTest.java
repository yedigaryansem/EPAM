package simpleCalculatorTestSuite;

import calculator.SimpleCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleCalculatorTest {

    @Test
    public void sumTest(){

        int testValue1 = 15;
        int testValue2 = 5;
        int actualValue = SimpleCalculator.sum(testValue1, testValue2);

        int expectedValue = 20;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void divTest(){

        float testValue1 = 15;
        float testValue2 = 5;
        float actualValue = SimpleCalculator.div(testValue1, testValue2);

        float expectedValue = 3;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void subTest(){

        int testValue1 = 15;
        int testValue2 = 5;
        int actualValue = SimpleCalculator.sub(testValue1, testValue2);

        int expectedValue = 10;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test()
    public void mulTest(){

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

    @Test(expectedExceptions = ArithmeticException.class)
    public void mulExceptionTest() throws ArithmeticException{

        int testValue1 = Integer.MAX_VALUE - 1;
        int testValue2 = 2;
        int actualValue = SimpleCalculator.mul(testValue1, testValue2);

    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void sumExceptionTest() throws ArithmeticException{

        int testValue1 = Integer.MAX_VALUE - 1;
        int testValue2 = Integer.MAX_VALUE - 1;
        int actualValue = SimpleCalculator.sum(testValue1, testValue2);

    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void subExceptionTest() throws ArithmeticException{

        int testValue1 = Integer.MIN_VALUE + 1;
        int testValue2 = Integer.MAX_VALUE;
        int actualValue = SimpleCalculator.sub(testValue1, testValue2);

    }

}