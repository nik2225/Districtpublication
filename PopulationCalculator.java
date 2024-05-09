import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Base class for center population calculation
class PopulationCalculator {
    protected ArrayList<Center> centers = new ArrayList<>();

    // Method to add center
    public void addCenter(String name, int population) {
        centers.add(new Center(name, population));
    }

    // Method to calculate total population of all centers
    public int calculateTotalPopulation() {
        int totalPopulation = 0;
        for (Center center : centers) {
            totalPopulation += center.getPopulation();
        }
        return totalPopulation;
    }

    // Method to display population by each center
    public void displayPopulationByCenter() {
        System.out.println("Population by each center:");
        for (Center center : centers) {
            System.out.println(center.getName() + ": " + center.getPopulation());
        }
    }

    // Method to read population data from a file
    public void readPopulationDataFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int population = Integer.parseInt(parts[1].trim());
                    addCenter(name, population);
                } else {
                    System.out.println("Invalid data format in file: " + line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (InputMismatchException e) {
            System.out.println("Invalid data format in file: " + e.getMessage());
        }
    }
}
