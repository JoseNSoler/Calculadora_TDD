package co.com.sofka.app.calculator;

import co.com.sofka.calculator.Calculator;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    public Calculator calculator = new Calculator();

    @Test
    public void emptyStringTest() throws Exception {

        Assertions.assertEquals(35,calculator.add("20 5 10"));

        Assertions.assertEquals(50,calculator.add("50 "));
    }
    @Test
    public void ignoreMore1000() throws Exception {
        Assertions.assertEquals(25,calculator.add("20 5 100000"));
    }

    @Test
    public void negativeNumber() throws Exception{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("20 5 -50");
        });

        String expectedMessage = "_ERROR: Numero negativo no valido";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
