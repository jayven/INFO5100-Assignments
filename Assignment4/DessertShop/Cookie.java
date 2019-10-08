package DessertShop;

public class Cookie extends DessertItem {
    private int number;
    private int pricePerDozen;

    public Cookie(String name, int number, int pricePerDozen) {
        super(name);
        this.pricePerDozen = pricePerDozen;
        this.number = number;
    }

    @Override
    public int getCost() {
        int totalPrice = (int) (number * pricePerDozen / 12);
        return totalPrice;
    }
}
