package com.example.calculator;

import com.example.calculator.strategies.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

@SpringBootApplication
public class CalculatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	@Bean
	public Calculator calculator(Map<Operation, OperationStrategy> strategyMap) {
		return new Calculator(strategyMap);
	}

	@Bean
	public Map<Operation, OperationStrategy> strategyMap(AddStrategy add,
														 SubtractStrategy sub,
														 MultiplyStrategy mul,
														 DivideStrategy div) {
		Map<Operation, OperationStrategy> map = new EnumMap<>(Operation.class);
		map.put(Operation.ADD, add);
		map.put(Operation.SUBTRACT, sub);
		map.put(Operation.MULTIPLY, mul);
		map.put(Operation.DIVIDE, div);
		return map;
	}

	@Bean
	public CommandLineRunner run(Calculator calculator) {
		return args -> {
			BigDecimal result = calculator.calculate(Operation.ADD, new BigDecimal("2.5"), new BigDecimal("3.1"));
			System.out.println("2.5 + 33.1 = " + result);

			BigDecimal chained = new CalculationChain(new BigDecimal("10"), calculator)
					.apply(Operation.SUBTRACT, new BigDecimal("3"))
					.apply(Operation.MULTIPLY, new BigDecimal("2"))
					.result();

			System.out.println("Chained = " + chained);
		};
	}
}
