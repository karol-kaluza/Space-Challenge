import java.util.Random;

public class U1 extends Rocket {

    public static final int rocketCostMln = 100;
    public static final int weightOfRocketKg = 10_000;
    public static final int maxWeightWithCargo = 18_000;
    public static final int launchExplosionChancePercent = 5;
    public static final int landingCrushChancePercent = 1;
    public static final double maxCargoCarry = 8_000;
    public static double currentCargoCarried = 0;

    public U1(int rocketCostMln, int weightOfRocketKg, int maxWeightWithCargo,
              double launchExplosionChancePercent, double landingCrushChancePercent, double maxCargoCarry, double currentCargoCarried) {
        super(rocketCostMln, weightOfRocketKg, maxWeightWithCargo,
                launchExplosionChancePercent, landingCrushChancePercent, maxCargoCarry, currentCargoCarried);
    }

    public U1() {
    }

    public double calcLunchChance() {
        double lunchU1ExplosionChanceResultPercent;
        lunchU1ExplosionChanceResultPercent = launchExplosionChancePercent * (this.getCurrentCargoCarried() / this.getMaxCargoCarry());
        return lunchU1ExplosionChanceResultPercent;
    }

    public double calcLandingChance() {
        double landingU1CrashChanceResultPercent = (landingCrushChancePercent) * (this.getCurrentCargoCarried() / this.getMaxCargoCarry());
        return landingU1CrashChanceResultPercent;
    }

    @Override
    public boolean launch() {
        boolean isLaunched;
        Random random = new Random();
        double randomNr = random.nextInt(100);    // for example chance for fail = 0.05 it's means that
        if (calcLunchChance() >= randomNr) {            // in 100 cases 5 times we should get less or equal for our value
            isLaunched = false;
        } else {
            isLaunched = true;
        }
        return isLaunched;
    }

    @Override
    public boolean land() {
        boolean isLanding;
        Random random = new Random();
        double randomNr = random.nextInt(100);
        if (calcLandingChance() >= randomNr) {
            isLanding = false;
        } else {
            isLanding = true;
        }
        return isLanding;
    }

    @Override
    public boolean canCarry(Item item) {
        return super.canCarry(item);
    }

    @Override
    public double carry(Item item) {
        return super.carry(item);
    }
}
