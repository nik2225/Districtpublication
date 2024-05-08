import java.util.Scanner;

public class DistrictPopulationSystem extends PopulationCalculator {
    public static void main(String[] args) {
        DistrictPopulationSystem district = new DistrictPopulationSystem();
        district.start();
    }

    // Method to start the population system
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of centers: ");
        int numCenters = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input center names and populations
        for (int i = 0; i < numCenters; i++) {
            System.out.print("Enter name of center " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter population of center " + (i + 1) + ": ");
            int population = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            addCenter(name, population);
        }

        // Menu-driven interface
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Calculate total population of all centers");
            System.out.println("2. Display population by each center");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Total population of all centers: " + calculateTotalPopulation());
                    break;
                case 2:
                    displayPopulationByCenter();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }

        scanner.close();
    }
}