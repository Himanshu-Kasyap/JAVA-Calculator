# CLI Calculator (Java)

A simple, robust Command-Line Interface (CLI) calculator built in Java. It allows users to perform basic mathematical operations interactively.

## Features

- **Standard Operations**: Addition (`+`), Subtraction (`-`), Multiplication (`*`), and Division (`/`).
- **Interactive Console Loop**: Runs continuously so you can perform multiple calculations back-to-back.
- **Robust Error Handling**:
  - Catches division by zero.
  - Detects and reports invalid mathematical operators.
  - Catches non-numeric inputs (e.g., typing letters instead of numbers) without crashing the application.
- **Graceful Termination**: Type `exit` at any prompt to quit the application.
- **Clean Output Formatting**: Automatically formats numbers (e.g., prints `5` instead of `5.0` if the result is a whole number).

## How to Run the Program

1. Ensure you have the Java Development Kit (JDK) installed and configured on your system.
2. Open your terminal in this directory.
3. Compile the Java source file:
   ```bash
   javac Calculator.java
   ```
4. Run the compiled class:
   ```bash
   java Calculator
   ```

## Implementation Details

- **Input Handling**: The application uses the `java.util.Scanner` class to read inputs line-by-line.
- **Control Flow**:
  - A `while (keepRunning)` loop keeps the program active until the user enters `exit`.
  - A `switch-case` statement is used to execute the correct mathematical operation based on the user's operator input (`+`, `-`, `*`, `/`).
- **Number Parsing**: Converts string inputs to `double` values using `Double.parseDouble(input)`. If parsing fails, a `NumberFormatException` is caught to warn the user and prompt them again.
