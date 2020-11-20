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

        ArrayList <U1> fleetU1PhaseOne = simulation.loadU1(itemsPhaseOne);
        ArrayList <U1> fleetU1PhaseTwo = simulation.loadU1(itemsPhaseTwo);

        ArrayList <U2> fleetU2PhaseOne = simulation.loadU2(itemsPhaseOne);
        ArrayList <U2> fleetU2PhaseTwo = simulation.loadU2(itemsPhaseTwo);

        int budgetU1PhaseOne = simulation.runSimulationU1(fleetU1PhaseOne);
        int budgetU1PhaseTwo = simulation.runSimulationU1(fleetU1PhaseTwo);
        int totalBudgetU1 = budgetU1PhaseOne + budgetU1PhaseTwo;
        System.out.println("  ");

        int budgetU2PhaseOne = simulation.runSimulationU2(fleetU2PhaseOne);
        int budgetU2PhaseTwo = simulation.runSimulationU2(fleetU2PhaseTwo);
        int totalBudgetU2 = budgetU2PhaseOne + budgetU2PhaseTwo;


        System.out.println(" ");
        System.out.println("Required total budget fleet U1 = " + totalBudgetU1 + " mln $");
        System.out.println("Required total budget fleet U2 = " + totalBudgetU2 + " mln $");

    }
}
