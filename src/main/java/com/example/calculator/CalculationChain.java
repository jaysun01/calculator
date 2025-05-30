package com.example.calculator;

import java.math.BigDecimal;

public class CalculationChain {
    private BigDecimal current;
    private final Calculator calculator;

    public CalculationChain(BigDecimal start, Calculator calculator) {
        this.current = start;
        this.calculator = calculator;
    }

    public CalculationChain apply(Operation op, BigDecimal value) {
        this.current = calculator.calculate(op, this.current, value);
        return this;
    }

    public BigDecimal result() {
        return current;
    }
}
