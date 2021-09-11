import Sweets.Candies;

import java.util.ArrayList;

public class Box implements Confections {

    private ArrayList<Candies> allCandiesList;

    public Box(ArrayList<Candies> allCandiesList) {
        this.allCandiesList = allCandiesList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Коробка сладостей состоит из:\n");
        for (Candies candies : allCandiesList) {
            builder.append("\n{ " + candies.getName() + ". Форма конфеты: " + candies.getShape() + " }\n");
        }
        return builder.toString();
    }

    public void addCandies(Candies candies) {
        allCandiesList.add(candies);
    }

    public void deleteCandies(Candies candies) {
        allCandiesList.remove(candies);
    }

    public double getWeightCandies() {
        double weight = 0;
        for (int i = 0; i < allCandiesList.size(); i++) {
            weight = weight + allCandiesList.get(i).getWeight();
        }
        return weight;
    }

    public double getPriceSweets() {
        double price = 0;
        for (int i = 0; i < allCandiesList.size(); i++) {
            price = price + allCandiesList.get(i).getPrice();
        }
        return price;
    }

    public void allSweetsInformation() {
        System.out.format("Вес: %.2f\nСтоимость: %.2f\n%s, ", getWeightCandies(), getPriceSweets(), this.toString());
    }
}
