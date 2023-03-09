package Drinks;

// BeverageDecorator abstract class
abstract class BeverageDecorator implements BeverageClass {
    protected BeverageClass wrappedBeverageClass;

    public BeverageDecorator(BeverageClass wrappedBeverageClass) {
        this.wrappedBeverageClass = wrappedBeverageClass;
    }

    @Override
    public void mix() {
        wrappedBeverageClass.mix();
    }

    @Override
    public double cost() {
        return wrappedBeverageClass.cost();
    }
}
