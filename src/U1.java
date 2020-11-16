import java.util.Random;

public class U1 extends Rocket {

    Rocket u1AgileRocket = new Rocket(100, 10_000, 18_000,
            5, 1);
    private double currentCargoCarried = 0;
    private double maxCargoCarry = u1AgileRocket.getMaxWeightWithCargo() - u1AgileRocket.getWeightOfRocketKg();
    private double lunchU1ExplosionChanceResultPercent = calcLunchChance();
    private double landingU1CrashChanceResultPercent = calcLandingChance();


    public U1(int rocketCostMln, int weightOfRocketKg, int maxWeightWithCargo, int launchExplosionChancePercent, int landingCrushChancePercent) {
        super(rocketCostMln, weightOfRocketKg, maxWeightWithCargo, launchExplosionChancePercent, landingCrushChancePercent);
    }

    public Rocket getU1AgileRocket() {
        return u1AgileRocket;
    }

    public double calcLunchChance() {
        lunchU1ExplosionChanceResultPercent = (u1AgileRocket.getLaunchExplosionChancePercent()) * (currentCargoCarried / maxCargoCarry);
        return lunchU1ExplosionChanceResultPercent;
    }

    private double calcLandingChance() {
        landingU1CrashChanceResultPercent = (u1AgileRocket.getLandingCrushChancePercent()) * (currentCargoCarried / maxCargoCarry);
        return landingU1CrashChanceResultPercent;
    }


    @Override
    public boolean launch() {
        boolean isLaunched;
        Random random = new Random();
        double randomNr = random.nextInt(100);          // for example chance for fail = 0.05 it's means that
        if (lunchU1ExplosionChanceResultPercent >= randomNr) {    // in 100 cases 5 times we should get less or equal for our value
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
        if (landingU1CrashChanceResultPercent >= randomNr) {
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
