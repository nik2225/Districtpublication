import java.util.*;
public class DistrictPopulationSystem extends PopulationCalculator {
    public static void main(String[] args) {
        DistrictPopulationSystem district = new DistrictPopulationSystem();
        district.start();
    }

    // Method to start the population system
    public void start() {
        Scanner scanner = new Scanner(System.in);

        // Menu-driven interface
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Enter population data manually");
            System.out.println("2. Load population data from file");
            System.out.println("3. Calculate total population of all centers");
            System.out.println("4. Display population by each center");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    enterPopulationManually(scanner);
                    break;
                case 2:
                    loadPopulationDataFromFile(scanner);
                    break;
                case 3:
                    System.out.println("Total population of all centers: " + calculateTotalPopulation());
                    break;
                case 4:
                    displayPopulationByCenter();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    // Method to enter population data manually
    public void enterPopulationManually(Scanner scanner) {
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
    }

    // Method to load population data from a file
    public void loadPopulationDataFromFile(Scanner scanner) {
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();
        readPopulationDataFromFile(filename);
    }
}
