# Calculator (Spring Boot + Strategy Pattern)

This project is a calculator system built with Java 17 and Spring Boot. It demonstrates clean design, extensibility via the Strategy pattern, IoC compatibility, and accurate arithmetic using `BigDecimal`.

---

## Requirements Fulfilled 

### 1. `Operation` Enum
- Defined an `enum Operation { ADD, SUBTRACT, MULTIPLY, DIVIDE }` to represent supported operations.

### 2. `calculate(Operation, Number, Number)`
- Implemented in the `Calculator` class.
- Uses a `Map<Operation, OperationStrategy>` to delegate computation.
- Accepts and returns `BigDecimal` for precision.

### 3. Chaining Operations
- Created a `CalculationChain` class.
- Allows chaining like: `start(5).apply(ADD, 3).apply(MULTIPLY, 2).result()`.

### 4. Extensibility (Open-Closed Principle)
- Each operation is implemented as a separate class (e.g. `AddStrategy`, `DivideStrategy`) implementing `OperationStrategy`.
- New operations can be added without modifying `Calculator`.

### 5. IoC Compatibility
- All operation strategies are registered as Spring `@Component`.
- Calculator and the strategy `Map` are Spring-managed beans.
- Supports full dependency injection and testability.

### 6. Error Handling
- Throws `UnsupportedOperationException` for unknown operations.
- Throws `ArithmeticException` for division by zero.
- Failures are predictable and handled safely.

### 7. Unit Testing
- Includes JUnit 5 tests with `@SpringBootTest`.
- Covers addition, chaining, and edge cases like divide-by-zero.

---

## Tech stack Used

- Java 17
- Spring Boot 3.5
- JUnit 5 
- BigDecimal 

---

## How to Run

```bash
# Run app
mvn spring-boot:run

# Run tests
mvn test

```

---

## Project Structure
```
calculator/
├── CalculatorApplication.java        
├── Calculator.java                   
├── CalculationChain.java             
├── Operation.java                    
├── OperationStrategy.java            
└── strategies/
    ├── AddStrategy.java
    ├── SubtractStrategy.java
    ├── MultiplyStrategy.java
    └── DivideStrategy.java
```
