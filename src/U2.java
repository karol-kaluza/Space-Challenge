import java.util.Random;

public class U2 extends Rocket {

    Rocket u2HeavyRocket = new Rocket(120, 10_000, 18_000,
            5, 1);

    private double currentCargoCarried = 0;
    private double maxCargoCarry = u2HeavyRocket.getMaxWeightWithCargo() - u2HeavyRocket.getWeightOfRocketKg();
    private double lunchU2ExplosionChanceResultPercent = calcLunchChance();
    private double landingU2CrashChanceResultPercent = calcLandingChance();

    public U2(int rocketCostMln, int weightOfRocketKg, int maxWeightWithCargo, int launchExplosionChancePercent, int landingCrushChancePercent) {
        super(rocketCostMln, weightOfRocketKg, maxWeightWithCargo, launchExplosionChancePercent, landingCrushChancePercent);
    }

    public Rocket getU2HeavyRocket() {
        return u2HeavyRocket;
    }

    private double calcLandingChance() {
        lunchU2ExplosionChanceResultPercent = (u2HeavyRocket.getLaunchExplosionChancePercent()) * (currentCargoCarried / maxCargoCarry);
        return lunchU2ExplosionChanceResultPercent;
    }

    private double calcLunchChance() {
        landingU2CrashChanceResultPercent = (u2HeavyRocket.getLandingCrushChancePercent()) * (currentCargoCarried / maxCargoCarry);
        return landingU2CrashChanceResultPercent;
    }

    @Override
    public boolean launch() {
        boolean isLaunched;
        Random random = new Random();
        double randomNr = random.nextInt(100);          // for example chance for fail = 0.05 it's means that
        if (lunchU2ExplosionChanceResultPercent >= randomNr) {    // in 100 cases 5 times we should get less or equal for our value
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
        if (landingU2CrashChanceResultPercent >= randomNr) {
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
}
