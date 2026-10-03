fun main() {
    println("========================================")
    println("      Simple Kotlin Calculator")
    println("========================================")
    println("This program lets the user enter two numbers and choose an operation.")
    println("It validates input and prevents division by zero.")
    println()

    val firstNumber = readValidatedNumber("Enter the first number: ") ?: return
    val secondNumber = readValidatedNumber("Enter the second number: ") ?: return

    displayMenu()

    val operation = readOperation()
    if (operation == "exit") {
        println("Thank you for using the calculator. Goodbye!")
        return
    }

    val result = calculate(firstNumber, secondNumber, operation)
    if (result == null) {
        println("Calculation could not be completed.")
        return
    }

    printResult(result)
}

// This function prints the calculator menu so the user knows which operations are available.
fun displayMenu() {
    println("Choose an operation:")
    println("  +  for addition")
    println("  -  for subtraction")
    println("  *  for multiplication")
    println("  /  for division")
    println("  exit to quit the program")
    println("----------------------------------------")
}

// Student function: This function reads the operator from the user and returns a valid choice or exit.
fun readOperation(): String {
    print("Enter your choice: ")
    val input = readLine()?.trim()

    return when (input) {
        "+", "-", "*", "/", "exit" -> input
        else -> {
            println("Invalid operation selected. Please try again.")
            "invalid"
        }
    }
}

// Student function: This function will perform the correct arithmetic based on the selected operator.
fun calculate(firstNumber: Double, secondNumber: Double, operation: String): Double? {
    return when (operation) {
        "+" -> add(firstNumber, secondNumber)
        "-" -> subtract(firstNumber, secondNumber)
        "*" -> multiply(firstNumber, secondNumber)
        "/" -> {
            val result = divide(firstNumber, secondNumber)
            if (result == null) {
                println("Error: Division by zero is not allowed.")
            }
            result
        }
        else -> {
            println("Error: This operation is not supported.")
            null
        }
    }
}

// Student function: This function adds two numbers together and returns the total.
fun add(a: Double, b: Double): Double {
    return a + b
}

// Student function: This function subtracts the second number from the first and returns the difference.
fun subtract(a: Double, b: Double): Double {
    return a - b
}

// Student function: This function multiplies two numbers and returns the product.
fun multiply(a: Double, b: Double): Double {
    return a * b
}

// Student function: This function divides the first number by the second number while checking for division by zero.
fun divide(a: Double, b: Double): Double? {
    if (b == 0.0) {
        return null
    }
    return a / b
}

// Student function: This function repeatedly asks for input until the user enters a valid number.
fun readValidatedNumber(prompt: String): Double? {
    while (true) {
        print(prompt)
        val input = readLine()

        if (input.isNullOrBlank()) {
            println("Error: Input cannot be empty.")
            continue
        }

        val number = try {
            input.toDouble()
        } catch (e: NumberFormatException) {
            println("Error: Please enter a valid number.")
            continue
        }

        return number
    }
}

// Student function: This function displays the final answer in a clear and readable format.
fun printResult(result: Double) {
    println("----------------------------------------")
    println("Result: $result")
    println("----------------------------------------")
}

// Student function: This function is a simple placeholder for future expansion, such as percentages or square roots.
fun futureFeatures() {
    println("Possible future upgrades:")
    println("- Percentage calculations")
    println("- Power function")
    println("- Square root")
    println("- Calculation history")
}
