package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    @Test
    public void testAddition() {
        double result = calculate(5, 3, '+');
        assertEquals(8.0, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double result = calculate(5, 3, '-');
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testMultiplication() {
        double result = calculate(5, 3, '*');
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testDivision() {
        double result = calculate(6, 3, '/');
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        // Use assertThrows to test for exceptions
        assertThrows(IllegalArgumentException.class, () -> calculate(5, 0, '/'));
    }

    @Test
    public void testInvalidOperator() {
        // Use assertThrows to test for exceptions
        assertThrows(IllegalArgumentException.class, () -> calculate(5, 3, '%'));
    }

    // Utility method to simulate the calculator logic
    private double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
