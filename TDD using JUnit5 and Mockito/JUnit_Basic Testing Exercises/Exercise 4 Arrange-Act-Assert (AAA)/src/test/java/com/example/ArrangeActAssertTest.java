package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrangeActAssertTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // Test fixture setup
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        // Cleanup
        calculator = null;
    }

    @Test
    void testAdd_AAA() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

}
