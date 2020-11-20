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
    private int totalRocketsSend = successCounter + explosionByStart + crashByLanding;

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
        ArrayList<U1> fleetRocketsU1 = new ArrayList<>();

        U1 u1Rocket = new U1(U1.rocketCostMln, U1.weightOfRocketKg, U1.maxWeightWithCargo,
                U1.launchExplosionChancePercent, U1.landingCrushChancePercent,
                U1.maxCargoCarry, 0);
        for (int i = 0; i < items.size(); i++) {
            if (u1Rocket.canCarry(items.get(i))) {
                u1Rocket.carry(items.get(i));
            }
            if (u1Rocket.getCurrentCargoCarried() >= u1Rocket.getMaxCargoCarry()
                    || items.get(i).getWeight() >= (u1Rocket.getMaxCargoCarry() - u1Rocket.getCurrentCargoCarried())) {
                fleetRocketsU1.add(u1Rocket);
                u1Rocket = new U1(U1.rocketCostMln, U1.weightOfRocketKg, U1.maxWeightWithCargo,
                        U1.launchExplosionChancePercent, U1.landingCrushChancePercent,
                        U1.maxCargoCarry, 0);
            }
        }
        return fleetRocketsU1;

    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> fleetRocketsU2 = new ArrayList<>();

        U2 u2Rocket = new U2(U2.rocketCostMln, U2.weightOfRocketKg, U2.maxWeightWithCargo,
                U2.launchExplosionChancePercent, U2.landingCrushChancePercent,
                U2.maxCargoCarry, 0);
        for (int i = 0; i < items.size(); i++) {
            if (u2Rocket.canCarry(items.get(i))) {
                u2Rocket.carry(items.get(i));
            }
            if (u2Rocket.getCurrentCargoCarried() >= u2Rocket.getMaxCargoCarry()
                    || items.get(i).getWeight() >= (u2Rocket.getMaxCargoCarry() - u2Rocket.getCurrentCargoCarried())) {
                fleetRocketsU2.add(u2Rocket);
                u2Rocket = new U2(U2.rocketCostMln, U2.weightOfRocketKg, U2.maxWeightWithCargo,
                        U2.launchExplosionChancePercent, U2.landingCrushChancePercent,
                        U2.maxCargoCarry, 0);
            }
        }
        return fleetRocketsU2;
    }

    public int runSimulationU1(ArrayList<U1> fleetOfRockets) {
        int currentBudget = 0;
        ArrayList<U1> totalRocketSend = new ArrayList<>();
        ArrayList<U1> crushedRockets = new ArrayList<>();   // must be send again
        ArrayList<U1> successfulRockets = new ArrayList<>();

        for (U1 currentRocket : fleetOfRockets) {
            if (currentRocket.launch() && currentRocket.land()) {
                successfulRockets.add(currentRocket);
                totalRocketSend.add(currentRocket);
                currentBudget += currentRocket.getRocketCostMln();
                System.out.println("Rocket U1 successful landed");
            } else if (currentRocket.launch() && !currentRocket.land()) {
                crushedRockets.add(currentRocket);
                totalRocketSend.add(currentRocket);
                currentBudget += currentRocket.getRocketCostMln();
                System.out.println("Rocket U1 crushed by landing");
            } else {
                crushedRockets.add(currentRocket);
                totalRocketSend.add(currentRocket);
                currentBudget += currentRocket.getRocketCostMln();
                System.out.println("Rocket U1 explosion by start");
            }
        }
        if (!crushedRockets.isEmpty()) {
            while (!crushedRockets.isEmpty()) {
                for (U1 currentNextRocket : fleetOfRockets) {
                    if (currentNextRocket.launch() && currentNextRocket.land()) {
                        crushedRockets.remove(crushedRockets.size() - 1);
                        successfulRockets.add(currentNextRocket);
                        totalRocketSend.add(currentNextRocket);
                        currentBudget += currentNextRocket.getRocketCostMln();
                        System.out.println("Rocket U1 successful landed");
                        if (crushedRockets.isEmpty()) {
                            return currentBudget;
                        }
                    } else if (currentNextRocket.launch() && !currentNextRocket.land()) {
                        totalRocketSend.add(currentNextRocket);
                        currentBudget += currentNextRocket.getRocketCostMln();
                        System.out.println("Rocket U1 crushed by landing again");
                        if (crushedRockets.isEmpty()) {
                            return currentBudget;
                        }
                    } else {
                        totalRocketSend.add(currentNextRocket);
                        currentBudget += currentNextRocket.getRocketCostMln();
                        System.out.println("Rocket U1 explosion by start again");
                        if (crushedRockets.isEmpty()) {
                            return currentBudget;
                        }
                    }
                }

            }
        }else {
            return currentBudget;
        }
        return currentBudget;
    }

    public int runSimulationU2(ArrayList<U2> fleetOfRockets) {
        int currentBudget = 0;
        ArrayList<U2> totalRocketSend = new ArrayList<>();
        ArrayList<U2> crushedRockets = new ArrayList<>();   // must be send again
        ArrayList<U2> successfulRockets = new ArrayList<>();

        for (U2 currentRocket : fleetOfRockets) {
            if (currentRocket.launch() && currentRocket.land()) {
                successfulRockets.add(currentRocket);
                totalRocketSend.add(currentRocket);
                currentBudget += currentRocket.getRocketCostMln();
                System.out.println("Rocket U2 successful landed");
            } else if (currentRocket.launch() && !currentRocket.land()) {
                crushedRockets.add(currentRocket);
                totalRocketSend.add(currentRocket);
                currentBudget += currentRocket.getRocketCostMln();
                System.out.println("Rocket U2 crushed by landing");
            } else {
                crushedRockets.add(currentRocket);
                totalRocketSend.add(currentRocket);
                currentBudget += currentRocket.getRocketCostMln();
                System.out.println("Rocket U2 explosion by start");
            }
        }
        if (!crushedRockets.isEmpty()) {
            while (!crushedRockets.isEmpty()) {
                for (U2 currentNextRocket : fleetOfRockets) {
                    if (currentNextRocket.launch() && currentNextRocket.land()) {
                        crushedRockets.remove(crushedRockets.size() - 1);
                        successfulRockets.add(currentNextRocket);
                        totalRocketSend.add(currentNextRocket);
                        currentBudget += currentNextRocket.getRocketCostMln();
                        System.out.println("Rocket U2 successful landed");
                        if (crushedRockets.isEmpty()) {
                            return currentBudget;
                        }
                    } else if (currentNextRocket.launch() && !currentNextRocket.land()) {
                        totalRocketSend.add(currentNextRocket);
                        currentBudget += currentNextRocket.getRocketCostMln();
                        System.out.println("Rocket U2 crushed by landing again");
                        if (crushedRockets.isEmpty()) {
                            return currentBudget;
                        }
                    } else {
                        totalRocketSend.add(currentNextRocket);
                        currentBudget += currentNextRocket.getRocketCostMln();
                        System.out.println("Rocket U2 explosion by start again");
                        if (crushedRockets.isEmpty()) {
                            return currentBudget;
                        }
                    }
                }

            }
        } else {
            return currentBudget;
        }
        return currentBudget;
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

    public int getTotalRocketsSend() {
        return totalRocketsSend;
    }
}