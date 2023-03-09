package Drinks;

// AddAlcohol class
class AddAlcohol extends BeverageDecorator {
    private final Alcohols alcohol;

    public AddAlcohol(BeverageClass wrappedBeverageClass, Alcohols alcohol) {
        super(wrappedBeverageClass);
        this.alcohol = alcohol;
    }

    @Override
    public void mix() {
        super.mix();
        System.out.println("Adding " + alcohol.name() + " to the drink.");
    }

    @Override
    public double cost() {
        return super.cost() + 2.0;
    }
}
