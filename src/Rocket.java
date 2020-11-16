public class Rocket implements SpaceShip {

    private int rocketCostMln;
    private int weightOfRocketKg;
    private int maxWeightWithCargo;
    private double launchExplosionChancePercent;
    private double landingCrushChancePercent;

    public Rocket(int rocketCostMln, int weightOfRocketKg, int maxWeightWithCargo,
                  int launchExplosionChancePercent, int landingCrushChancePercent) {
        this.rocketCostMln = rocketCostMln;
        this.weightOfRocketKg = weightOfRocketKg;
        this.maxWeightWithCargo = maxWeightWithCargo;
        this.launchExplosionChancePercent = launchExplosionChancePercent;
        this.landingCrushChancePercent = landingCrushChancePercent;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        boolean isCarryPossible;
        if (item.getWeight() + weightOfRocketKg <= maxWeightWithCargo) {
            return isCarryPossible = true;
        } else {
            return isCarryPossible = false;
        }
    }

    @Override
    public int carry(Item item) {
        int updatedWeightOfRocket;
        if (weightOfRocketKg + item.getWeight() <= maxWeightWithCargo) {
            updatedWeightOfRocket = weightOfRocketKg + item.getWeight();
            return updatedWeightOfRocket;
        } else {
            System.out.println("Warning ! Rocket is too heavy");
            updatedWeightOfRocket = weightOfRocketKg + item.getWeight();
            return updatedWeightOfRocket;
        }
    }

    public int getRocketCostMln() {
        return rocketCostMln;
    }

    public void setRocketCostMln(int rocketCostMln) {
        this.rocketCostMln = rocketCostMln;
    }

    public int getWeightOfRocketKg() {
        return weightOfRocketKg;
    }

    public void setWeightOfRocketKg(int weightOfRocketKg) {
        this.weightOfRocketKg = weightOfRocketKg;
    }

    public int getMaxWeightWithCargo() {
        return maxWeightWithCargo;
    }

    public void setMaxWeightWithCargo(int maxWeightWithCargo) {
        this.maxWeightWithCargo = maxWeightWithCargo;
    }

    public double getLaunchExplosionChancePercent() {
        return launchExplosionChancePercent;
    }

    public void setLaunchExplosionChancePercent(double launchExplosionChancePercent) {
        this.launchExplosionChancePercent = launchExplosionChancePercent;
    }

    public double getLandingCrushChancePercent() {
        return landingCrushChancePercent;
    }

    public void setLandingCrushChancePercent(double landingCrushChancePercent) {
        this.landingCrushChancePercent = landingCrushChancePercent;
    }
}
