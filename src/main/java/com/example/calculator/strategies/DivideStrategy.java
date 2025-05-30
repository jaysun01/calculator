package com.example.calculator.strategies;

import com.example.calculator.OperationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class DivideStrategy implements OperationStrategy {
    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a.divide(b, 10, RoundingMode.HALF_UP);
    }
}
