public class U2 extends Rocket {
    @Override
    public boolean launch(int cargoCarried, int cargoLimit, int percentExplosionChance) {
        return super.launch(cargoCarried, cargoLimit, percentExplosionChance);
    }

    @Override
    public boolean land(int cargoCarried, int cargoLimit, int percentExplosionChance) {
        return super.land(cargoCarried, cargoLimit, percentExplosionChance);
    }
}
