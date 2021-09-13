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
    public void allSweetsInformationAfterRebalanceWeight(double weight) {
        System.out.format("Вес: %.2f\nСтоимость: %.2f\n%s, ", removeWeightCandies(weight), getPriceSweets(), this.toString());
    }
    public void allSweetsInformationAfterRebalancePrice(double price) {
        System.out.format("Вес: %.2f\nСтоимость: %.2f\n%s, ", getWeightCandies(), removePriceCandies(price), this.toString());
    }

    public double removeWeightCandies(double maxWeightCandies) {
        double weightBox = 0;
        double minWeight = allCandiesList.get(0).getWeight();
        for (int i = 0; i < allCandiesList.size(); i++) {
            if (allCandiesList.get(i).getWeight() < minWeight) {
                minWeight = allCandiesList.get(i).getWeight();
            }
            weightBox = weightBox + allCandiesList.get(i).getWeight();

        }

        while (!(weightBox == maxWeightCandies)) {
            if (weightBox > maxWeightCandies) {
                weightBox -= minWeight;

            }
            break;
        }
        return weightBox;
    }

    public double removePriceCandies(double maxPriceCandies) {
        double priceBox = 0;
        double minPrice = allCandiesList.get(0).getPrice();
        for (int i = 0; i < allCandiesList.size(); i++) {
            if (allCandiesList.get(i).getPrice() < minPrice) {
                minPrice = allCandiesList.get(i).getPrice();
            }
            priceBox = priceBox + allCandiesList.get(i).getPrice();
        }

        while (!(priceBox == maxPriceCandies)) {
            if (priceBox > maxPriceCandies) {
                priceBox -= minPrice;
            }
            break;
        }
        return priceBox;
    }
}