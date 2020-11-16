public interface SpaceShip {

    default boolean launch() {
        return true;
    }

    default boolean land() {
        return true;
    }

    default boolean canCarry (Item item){
        return true;
    }

    default int carry (Item item){
        return 0;
    }


}
