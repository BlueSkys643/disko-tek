package LoginRegister;

public class ItemData {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String description;
    public String[] parameters;
    public float price;
    enum ItemType {
        FOOD,
        DRINKS
    }
    public ItemData(String name, String description, String[] parameters, float price) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.price = price;
    }
    @Override
    public String toString(){
        StringBuilder paramsOut = new StringBuilder("Parameters: ");
        for(String parameter : parameters) {
            paramsOut.append(parameter);
        }
        return "Item name: " + this.name +
                "\nItem Description: " + this.description +
                "\nItem Parameters: " + paramsOut +
                "\nItem Price: " + this.price;
    }
}
