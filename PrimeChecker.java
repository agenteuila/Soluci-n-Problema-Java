import java.util.Scanner;

/**
 * Prime Number Checker Application
 * 
 * Student: Camilo Andrés Vega Díaz
 * University: Politécnico Grancolombiano
 * 
 * This program checks if a given positive integer is a prime number.
 * A prime number is a natural number greater than 1 that has no positive 
 * divisors other than 1 and itself.
 */
public class PrimeChecker {
    
    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        // Display student information
        displayStudentInfo();
        
        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("VERIFICADOR DE NÚMEROS PRIMOS");
        System.out.println("=".repeat(50));
        
        try {
            // Get user input
            int number = getUserInput(scanner);
            
            // Check if the number is prime
            boolean isPrime = isPrimeNumber(number);
            
            // Display result
            displayResult(number, isPrime);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Displays student information at the beginning of the program
     */
    private static void displayStudentInfo() {
        System.out.println("=".repeat(60));
        System.out.println("INFORMACIÓN DEL ESTUDIANTE");
        System.out.println("=".repeat(60));
        System.out.println("Nombre completo: Camilo Andrés Vega Díaz");
        System.out.println("Universidad: Politécnico Grancolombiano");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Gets a positive integer input from the user with validation
     * 
     * @param scanner Scanner object for reading user input
     * @return A positive integer entered by the user
     */
    private static int getUserInput(Scanner scanner) {
        int number;
        
        while (true) {
            System.out.print("\nIngrese un número entero positivo: ");
            
            try {
                number = scanner.nextInt();
                
                if (number <= 0) {
                    System.out.println("Error: Por favor ingrese un número entero positivo (mayor que 0).");
                    continue;
                }
                
                break;
                
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un número entero válido.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        
        return number;
    }
    
    /**
     * Checks if a given number is prime using an efficient algorithm
     * 
     * Algorithm explanation:
     * - Numbers less than 2 are not prime
     * - 2 is the only even prime number
     * - For odd numbers, check divisibility only up to sqrt(n)
     * - Only check odd divisors to optimize performance
     * 
     * @param n The number to check for primality
     * @return true if the number is prime, false otherwise
     */
    private static boolean isPrimeNumber(int n) {
        // Handle special cases
        if (n < 2) {
            return false;
        }
        
        if (n == 2) {
            return true; // 2 is the only even prime number
        }
        
        if (n % 2 == 0) {
            return false; // Even numbers greater than 2 are not prime
        }
        
        // Check for odd divisors up to sqrt(n)
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false; // Found a divisor, so it's not prime
            }
        }
        
        return true; // No divisors found, it's prime
    }
    
    /**
     * Displays the result of the prime check in a formatted way
     * 
     * @param number The number that was checked
     * @param isPrime Whether the number is prime or not
     */
    private static void displayResult(int number, boolean isPrime) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESULTADO");
        System.out.println("=".repeat(50));
        
        if (isPrime) {
            System.out.println("✓ El número " + number + " ES un número primo.");
            System.out.println("\nExplicación: Un número primo solo es divisible por 1 y por sí mismo.");
            System.out.println("El número " + number + " cumple con esta condición.");
        } else {
            System.out.println("✗ El número " + number + " NO ES un número primo.");
            System.out.println("\nExplicación: Un número primo solo es divisible por 1 y por sí mismo.");
            System.out.println("El número " + number + " tiene otros divisores además de 1 y " + number + ".");
            
            // Show some factors for non-prime numbers (optional enhancement)
            if (number > 1) {
                showFactors(number);
            }
        }
        
        System.out.println("=".repeat(50));
    }
    
    /**
     * Shows some factors of a non-prime number (educational purpose)
     * 
     * @param number The number to find factors for
     */
    private static void showFactors(int number) {
        System.out.print("Algunos divisores encontrados: 1");
        
        int factorCount = 1;
        for (int i = 2; i <= number && factorCount < 5; i++) {
            if (number % i == 0) {
                System.out.print(", " + i);
                factorCount++;
            }
        }
        
        if (factorCount >= 5 && number > 10) {
            System.out.print(", ...");
        }
        
        System.out.println();
    }
}
