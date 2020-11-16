import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private String filePhase1 = "phase-1.txt";
    private String filePhase2 = "phase-2.txt";


    ArrayList<Item> items = new ArrayList<>();

    private ArrayList <Item> loadItems(Scanner file) {
        ArrayList <Item> items = new ArrayList<>();
        while (file.hasNextLine()){
            String [] separatedStrings = file.nextLine().split("=");
            String itmName = separatedStrings[0];
            int itWeight = (Integer.parseInt(separatedStrings[1]));
            items.add(new Item(itmName,itWeight));
        }
        return items;
    }
}
