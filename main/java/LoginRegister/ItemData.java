pa
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String gckage LoginRegister;

    public class ItemData {
        public String name;
        public String description;
        public String[] parameters;
        public float price;
        public LoginRegister.ItemData.ItemType itemType;
        //private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
        enum ItemType {
            FOOD,
            DRINKS
        }

        public ItemData() {
        }
        public ItemData(String name, String description, String[] parameters, float price, LoginRegister.ItemData.ItemType itemType) {
            this.name = name;
            this.description = description;
            this.parameters = parameters;
            this.price = price;
            this.itemType = itemType;
        }etDescription() {
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
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
}
