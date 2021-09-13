import Sweets.Candies;
import Sweets.CaramelCandies;
import Sweets.ChocolateCandies;
import Sweets.Marmalade;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Box box = new Box(new ArrayList<>());

        box.addCandies(new ChocolateCandies());
        box.addCandies(new Marmalade());
        box.addCandies(new Marmalade());
        box.addCandies(new CaramelCandies());
        box.allSweetsInformation();
        box.allSweetsInformationAfterRebalancePrice(300);
        box.allSweetsInformationAfterRebalanceWeight(1000);

    }
}



