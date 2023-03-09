package Drinks;

// ConcreteCocktail class
class ConcreteCocktail implements BeverageClass {
    public ConcreteCocktail() {
        System.out.println("Ordering a cocktail.");
    }

    @Override
    public void mix() {
        System.out.println("Mixing the cocktail.");
    }

    @Override
    public double cost() {
        return 10.0;
    }
}
