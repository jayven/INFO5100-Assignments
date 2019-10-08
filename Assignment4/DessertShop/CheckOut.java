package DessertShop;

import java.util.ArrayList;
import java.util.List;

public class CheckOut {
    List<DessertItem> checkOut = new ArrayList<DessertItem>();

    public int numberOfItems() {
        return checkOut.size();
    }

    public void enterItem(DessertItem item) {
        checkOut.add(item);
    }

    public void clear() {
        checkOut.clear();
    }

    public int totalCost() {
        int totalCost = 0;
        for (DessertItem items : checkOut)
            totalCost = totalCost + items.getCost();
        return totalCost;
    }

    public int totalTax() {
        int totalTax = (int) (this.totalCost() * DessertShop.taxRate);
        return totalTax;
    }

    public String toString() {
        String receipt = DessertShop.StoreName + "\n";
        receipt = receipt + "--------------------" + "\n" + "\n";
        for (DessertItem items : checkOut) {
            receipt += items.toString() + "      " + DessertShop.cents2dollarsAndCentsmethod(items.getCost()) + "\n";
        }
        receipt += "Tax" + "      " + DessertShop.cents2dollarsAndCentsmethod(this.totalTax()) + "\n";
        receipt += "Total Cost" + "      " + DessertShop.cents2dollarsAndCentsmethod(this.totalTax() + this.totalCost());
        return receipt;

    }
}
