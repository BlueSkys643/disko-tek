package Drinks;

// ConcreteShot class
class ConcreteShot implements BeverageClass {
    public ConcreteShot() {
        System.out.println("Ordering a shot.");
    }

    @Override
    public void mix() {
        System.out.println("Mixing the shot.");
    }

    @Override
    public double cost() {
        return 5.0;
    }
}
