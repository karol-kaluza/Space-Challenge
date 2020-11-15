public class Rocket implements SpaceShip {
    @Override
    public boolean launch(int cargoCarried, int cargoLimit, int percentExplosionChance) {
        return false;
    }

    @Override
    public boolean land(int cargoCarried, int cargoLimit, int percentExplosionChance) {
        return false;
    }

    @Override
    public boolean canCarry(Item item) {
        return false;
    }

    @Override
    public int carry(Item item) {
        return 0;
    }
}
