package DessertShop;

public class Sundae extends IceCream {
    private int toppingPrice;
    protected String toppingName;

    public Sundae(String name, int cost, String toppingName, int toppingPrice) {
        super(name, cost);
        this.toppingPrice = toppingPrice;
        this.toppingName = toppingName;
    }

    public int getCost() {
        return (int) super.cost + toppingPrice;
    }
}
