package org.example

// Workshop #1: Simple Console Application - Unit Converter

fun main() {
    // Loop to keep the program running until the user exits
    while (true) {
        // 1. Display the menu for the user
        println("===== Unit Converter =====")
        println("Please select the desired conversion:")
        println("1. Celsius to Fahrenheit")
        println("2. Kilometers to Miles")
        println("Type 'exit' to quit the program")
        print("Select an option (1, 2, or exit): ")

        // 2. Read the user's choice
        val choice = readlnOrNull()

        // 3. Control the program flow using a when expression
        when (choice) {
            "1" -> processCelsiusConversion()
            "2" -> processKilometersConversion()
            "exit" -> {
                println("Exiting the program. Goodbye!")
                return // Exit the main function, terminating the program
            }
            else -> {
                // Handle invalid menu choices
                println("Invalid option, please try again.")
            }
        }
        println() // Print a blank line for better readability
    }
}

// Function to handle the entire Celsius to Fahrenheit conversion process
fun processCelsiusConversion() {
    print("Enter the temperature in Celsius: ")
    val input = readlnOrNull()

    // 5. Handle Null Safety using toDoubleOrNull() and the Elvis operator (?:)
    // If input is null or not a valid Double, print an error and return.
    val celsius = input?.toDoubleOrNull() ?: run {
        println("Invalid input. Please enter a valid number.")
        return
    }

    val fahrenheitResult = celsiusToFahrenheit(celsius)

    // 6. Display the result, formatted to two decimal places
    println("Result: $celsius °C is equal to ${"%.2f".format(fahrenheitResult)} °F")
}

// Function to handle the entire Kilometers to Miles conversion process
fun processKilometersConversion() {
    print("Enter the distance in Kilometers: ")
    val input = readlnOrNull()

    // 5. Handle Null Safety using toDoubleOrNull() and the Elvis operator (?:)
    // If input is null or not a valid Double, print an error and return.
    val kilometers = input?.toDoubleOrNull() ?: run {
        println("Invalid input. Please enter a valid number.")
        return
    }

    val milesResult = kilometersToMiles(kilometers)

    // 6. Display the result, formatted to two decimal places
    println("Result: $kilometers km is equal to ${"%.2f".format(milesResult)} miles")
}


// 4. A separate, pure function for the Celsius to Fahrenheit conversion calculation
// Formula: celsius * 9.0 / 5.0 + 32
fun celsiusToFahrenheit(celsius: Double): Double {
    return celsius * 9.0 / 5.0 + 32
}

// 4. A separate, pure function for the Kilometers to Miles conversion calculation
// Formula: kilometers * 0.621371
fun kilometersToMiles(kilometers: Double): Double {
    return kilometers * 0.621371
}