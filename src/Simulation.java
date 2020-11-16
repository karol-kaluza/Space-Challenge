import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private int totalBudget = 0;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<U1> u1rockets = new ArrayList<>();
    ArrayList<U2> u2rockets = new ArrayList<>();
    private int successCounter = 0;
    private int explosionByStart = 0;
    private int crashByLanding = 0;

    public ArrayList<Item> loadItems(Scanner scanFile) {
        ArrayList<Item> items = new ArrayList<>();
        while (scanFile.hasNextLine()) {
            String[] separatedStrings = scanFile.nextLine().split("=");
            String itmName = separatedStrings[0];
            int itWeight = (Integer.parseInt(separatedStrings[1]));
            items.add(new Item(itmName, itWeight));
        }
        return items;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> u1rockets = new ArrayList<>();
        U1 u1Rocket = new U1(U1.rocketCostMln, U1.weightOfRocketKg, U1.maxWeightWithCargo,
                U1.launchExplosionChancePercent, U1.landingCrushChancePercent, U1.maxCargoCarry);
        for (Item element : items) {
            while (!u1Rocket.canCarry(element)) {
                u1rockets.add(new U1(U1.rocketCostMln, U1.weightOfRocketKg, U1.maxWeightWithCargo,
                        U1.launchExplosionChancePercent, U1.landingCrushChancePercent, U1.maxCargoCarry));
            }
            u1Rocket.carry(element);
        }
        return u1rockets;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> u1rockets = new ArrayList<>();
        U2 u2Rocket = new U2(U2.rocketCostMln, U2.weightOfRocketKg, U2.maxWeightWithCargo,
                U2.launchExplosionChancePercent, U2.landingCrushChancePercent, U2.maxCargoCarry);
        for (Item element : items) {
            while (!u2Rocket.canCarry(element)) {
                u1rockets.add(new U2(U2.rocketCostMln, U2.weightOfRocketKg, U2.maxWeightWithCargo,
                        U2.launchExplosionChancePercent, U2.landingCrushChancePercent, U2.maxCargoCarry));
            }
            u2Rocket.carry(element);
        }
        return u1rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int currentBudget = 0;

        for (Rocket rocket : rockets) {
            if (rocket.launch() && rocket.land()) {
                successCounter++;
                currentBudget += rocket.getRocketCostMln();
                System.out.println("Rocket successful landed on Mars");
            } else if (rocket.launch() && !rocket.land()) {
                crashByLanding++;
                currentBudget += rocket.getRocketCostMln();
                System.out.println("Rocket crushed by landing");
            } else {
                explosionByStart++;
                currentBudget += rocket.getRocketCostMln();
                System.out.println("Rocket exploded by start");
            }


        } return currentBudget;
    }

    public int getTotalBudget() {
        return totalBudget;
    }

    public int getSuccessCounter() {
        return successCounter;
    }

    public int getExplosionByStart() {
        return explosionByStart;
    }

    public int getCrashByLanding() {
        return crashByLanding;
    }
}