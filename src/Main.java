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

        ArrayList <Item> itemsPhaseOne = simulation.loadItems(scanFile1);
        ArrayList <Item> itemsPhaseTwo = simulation.loadItems(scanFile2);

        ArrayList <Rocket> rocketsU1PhaseOne = simulation.loadU1(itemsPhaseOne);
        ArrayList <Rocket> rocketsU1PhaseTwo = simulation.loadU1(itemsPhaseTwo);

        int budgetU1PhaseOne = simulation.runSimulation(rocketsU1PhaseOne);
        int budgetU1PhaseTwo = simulation.runSimulation(rocketsU1PhaseTwo);
        int totalBudgetU1 = budgetU1PhaseTwo + budgetU1PhaseTwo;

        ArrayList <Rocket> rocketsU2PhaseOne = simulation.loadU2(itemsPhaseOne);
        ArrayList <Rocket> rocketsU2PhaseTwo = simulation.loadU2(itemsPhaseTwo);

        int budgetU2PhaseOne = simulation.runSimulation(rocketsU2PhaseOne);
        int budgetU2PhaseTwo = simulation.runSimulation(rocketsU2PhaseTwo);
        int totalBudgetU2 = budgetU1PhaseTwo + budgetU1PhaseTwo;

        System.out.println("Required total budget fleet U1 = " + totalBudgetU1 + " mln $");
        System.out.println("Required total budget fleet U2 = " + totalBudgetU2 + " mln $");

    }
}
