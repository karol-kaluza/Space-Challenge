import java.util.Random;

public class U2 extends Rocket {

    public static final int rocketCostMln = 120;
    public static final int weightOfRocketKg = 18_000;
    public static final int maxWeightWithCargo = 29_000;
    public static final int launchExplosionChancePercent = 4;
    public static final int landingCrushChancePercent = 8;
    public static final double maxCargoCarry = 11_000;
    public static double currentCargoCarried;

    public U2(int rocketCostMln, int weightOfRocketKg, int maxWeightWithCargo,
              double launchExplosionChancePercent, double landingCrushChancePercent, double currentCargoCarried) {
        super(rocketCostMln, weightOfRocketKg, maxWeightWithCargo,
                launchExplosionChancePercent, landingCrushChancePercent, currentCargoCarried);
    }

    public static double calcLunchChance() {
        double lunchU2ExplosionChanceResultPercent = (launchExplosionChancePercent) * (currentCargoCarried / maxCargoCarry);
        return lunchU2ExplosionChanceResultPercent;
    }

    public static double calcLandingChance() {
        double landingU2CrashChanceResultPercent = (landingCrushChancePercent) * (currentCargoCarried / maxCargoCarry);
        return landingU2CrashChanceResultPercent;
    }

    @Override
    public boolean launch() {
        boolean isLaunched;
        Random random = new Random();
        double randomNr = random.nextInt(100);      // for example chance for fail = 0.04 it's means that
        if (calcLunchChance() >= randomNr) {               // in 100 cases 4 times we should get less or equal for our value
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
    public int carry(Item item) {
        return super.carry(item);
    }
}
