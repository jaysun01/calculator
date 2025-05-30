package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorApplicationTests {

	@Autowired
	private Calculator calculator;

	@Test
	void testAddition() {
		BigDecimal result = calculator.calculate(Operation.ADD, new BigDecimal("1.2"), new BigDecimal("3.4"));
		assertEquals(new BigDecimal("4.6"), result);
	}

	@Test
	void testChain() {
		BigDecimal result = new CalculationChain(new BigDecimal("10"), calculator)
				.apply(Operation.SUBTRACT, new BigDecimal("2"))
				.apply(Operation.MULTIPLY, new BigDecimal("5"))
				.result();

		assertEquals(new BigDecimal("40"), result);
	}

	@Test
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, () ->
				calculator.calculate(Operation.DIVIDE, BigDecimal.TEN, BigDecimal.ZERO));
	}
}
