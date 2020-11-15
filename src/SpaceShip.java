public interface SpaceShip {
    default boolean launch(int cargoCarried, int cargoLimit, int percentExplosionChance) {
        boolean isLunched = true;
        // miejsce na wzór
        return isLunched;
    }

    default boolean land(int cargoCarried, int cargoLimit, int percentExplosionChance) {
        boolean isLanded = true;
        // miejsce na wzór
        return isLanded;
    }

    default boolean canCarry (Item item){
        boolean carryPossibility = true;
        // miejsce na wzór
        return carryPossibility;
    }

    default int carry (Item item){
        int updetedWeight = item.getWeight();
        // miejsca na wzór
        return  updetedWeight;
    }


}
