import java.util.ArrayList;
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


}

// Class representing a center

