package DessertShop;

public class Candy extends DessertItem{
    private double weight;
    private double pricePerPound;

    public Candy(String name, double weight, double price){
        super(name);
        this.pricePerPound = pricePerPound;
        this.weight = weight;
    }

    @Override
    public int getCost() {
        int totalPrice = (int) (weight * pricePerPound);
        return totalPrice;
    }
}
