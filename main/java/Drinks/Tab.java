package Drinks;

import java.util.ArrayList;
import java.util.List;

class Tab {
    private final List<BeverageClass> beverages = new ArrayList<>();

    public void orderDrink(String drinkType, Alcohols alcohol, Mixers mixer) {
        BeverageClass drink;
        if (drinkType.equalsIgnoreCase("shot")) {
            drink = new ConcreteShot();
        } else if (drinkType.equalsIgnoreCase("cocktail")) {
            drink = new ConcreteCocktail();
        } else {
            System.out.println("Invalid drink type.");
            return;
        }

        if (alcohol != null) {
            drink = new AddAlcohol(drink, alcohol);
        }
        if (mixer != null) {
            drink = new AddMixer(drink, mixer);
        }

        beverages.add(drink);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (BeverageClass beverage : beverages) {
            total += beverage.cost();
        }
        return total;
    }
}


