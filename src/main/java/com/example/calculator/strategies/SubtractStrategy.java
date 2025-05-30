package com.example.calculator.strategies;

import com.example.calculator.OperationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SubtractStrategy implements OperationStrategy {
    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }
}
