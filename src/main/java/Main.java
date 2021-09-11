import Sweets.Candies;
import Sweets.CaramelCandies;
import Sweets.ChocolateCandies;
import Sweets.Marmalade;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Candies> list = new ArrayList<Candies>();
        Box box = new Box(list);

        list.add(new ChocolateCandies());
        list.add(new ChocolateCandies());
        list.add(new CaramelCandies());
        list.add(new CaramelCandies());
        list.add(new Marmalade());
        list.add(new Marmalade());
        list.add(new Marmalade());
        list.add(new Marmalade());
        box.allSweetsInformation();
    }
}


