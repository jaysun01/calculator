package com.example.calculator;

import java.math.BigDecimal;

public interface OperationStrategy {
    BigDecimal apply(BigDecimal a, BigDecimal b);
}
