package Drinks;

// AddMixer class
class AddMixer extends BeverageDecorator {
    private Mixers mixer;

    public AddMixer(BeverageClass wrappedBeverageClass, Mixers mixer) {
        super(wrappedBeverageClass);
        this.mixer = mixer;
    }

    @Override
    public void mix() {
        super.mix();
        System.out.println("Adding " + mixer.name() + " to the drink.");
    }

    @Override
    public double cost() {
        return super.cost() + 1.0;
    }

    public void newBehavior() {
        System.out.println("Adding new behavior to the drink.");
    }
}
