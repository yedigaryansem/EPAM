package simpleCalculatorTestSuite;

import java.io.IOException;

import calculator.SimpleCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SimpleCalculatorTest {

    @Test
    public void sumTest() throws Exception{

        int testValue1 = 15;
        int testValue2 = 5;
        int actualValue = SimpleCalculator.sum(testValue1, testValue2);

        int expectedValue = 20;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void divTest() throws Exception{

        float testValue1 = 15;
        float testValue2 = 5;
        float actualValue = SimpleCalculator.div(testValue1, testValue2);

        float expectedValue = 3;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void subTest() throws Exception{

        int testValue1 = 15;
        int testValue2 = 5;
        int actualValue = SimpleCalculator.sub(testValue1, testValue2);

        int expectedValue = 10;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test()
    public void mulTest() throws Exception{

        int testValue1 = 4;
        int testValue2 = 5;
        int actualValue = SimpleCalculator.mul(testValue1, testValue2);

        int expectedValue = 20;

        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test(expectedExceptions = Exception.class)
    public void divExceptionTest() throws Exception{

        float testValue1 = 5;
        float testValue2 = 0;
        float actualValue = SimpleCalculator.div(testValue1, testValue2);

    }

    @Test(expectedExceptions = Exception.class)
    public void mulExceptionTest() throws Exception{

        int testValue1 = Integer.MAX_VALUE - 1; // Integer's maximum value is 2147483647 .
        int testValue2 = 2;
        int actualValue = SimpleCalculator.mul(testValue1, testValue2);

    }

    @Test(expectedExceptions = Exception.class)
    public void sumExceptionTest() throws Exception{

        int testValue1 = Integer.MAX_VALUE - 1; // Integer's maximum value is 2147483647 .
        int testValue2 = Integer.MAX_VALUE - 1;
        int actualValue = SimpleCalculator.sum(testValue1, testValue2);

    }

    @Test(expectedExceptions = Exception.class)
    public void subExceptionTest() throws Exception{

        int testValue1 = Integer.MIN_VALUE + 1; // Integer's minimum value is -2147483648 .
        int testValue2 = Integer.MAX_VALUE;     // Integer's maximum value is 2147483647 .
        int actualValue = SimpleCalculator.sub(testValue1, testValue2);

    }


}

