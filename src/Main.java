import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String filePhase1 = "phase-1.txt";
        String filePhase2 = "phase-2.txt";
        File file1 = new File(filePhase1);
        File file2 = new File(filePhase2);
        Scanner scanFile1 = new Scanner(file1);
        Scanner scanFile2 = new Scanner(file2);

        Simulation simulation = new Simulation();

        ArrayList <Item> itemsPhase1 = new ArrayList<>();
        simulation.loadItems(scanFile1);

        ArrayList <Item> itemsPhase2 = new ArrayList<>();
        simulation.loadItems(scanFile2);

        ArrayList <Rocket> rocketsU1 = new ArrayList<>();
        simulation.loadU1(itemsPhase1);
        simulation.loadU1(itemsPhase2);

        int budgetU1 = simulation.runSimulation(rocketsU1);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Total rockets U1 send: " + simulation.getTotalRocketsSend());
        System.out.println("Required budget: " + budgetU1 + " mln $");

    }
}
