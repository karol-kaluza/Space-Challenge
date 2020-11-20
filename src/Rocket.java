public class Rocket implements SpaceShip {

    private int rocketCostMln;
    private int weightOfRocketKg;
    private int maxWeightWithCargo;
    private double launchExplosionChancePercent;
    private double landingCrushChancePercent;
    private double maxCargoCarry;
    private double currentCargoCarried;


    public Rocket(int rocketCostMln, int weightOfRocketKg, int maxWeightWithCargo,
                  double launchExplosionChancePercent, double landingCrushChancePercent,
                  double maxCargoCarry, double currentCargoCarried) {
        this.rocketCostMln = rocketCostMln;
        this.weightOfRocketKg = weightOfRocketKg;
        this.maxWeightWithCargo = maxWeightWithCargo;
        this.launchExplosionChancePercent = launchExplosionChancePercent;
        this.landingCrushChancePercent = landingCrushChancePercent;
        this.maxCargoCarry = maxCargoCarry;
        this.currentCargoCarried = currentCargoCarried;
    }

    public Rocket() {

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
        if(maxCargoCarry >= currentCargoCarried + item.getWeight()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public double carry(Item item) {
        return (currentCargoCarried += item.getWeight());
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

    public double getMaxCargoCarry() {
        return maxCargoCarry;
    }

    public void setMaxCargoCarry(double maxCargoCarry) {
        this.maxCargoCarry = maxCargoCarry;
    }

    public double getCurrentCargoCarried() {
        return currentCargoCarried;
    }

    public void setCurrentCargoCarried(double currentCargoCarried) {
        this.currentCargoCarried = currentCargoCarried;
    }
}
