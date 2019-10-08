package DessertShop;

public class DessertShop {
    public final static double taxRate = 0.08;
    public final static String StoreName = "Glossy Desserts";
    public final static int itemNameMaxSize = 25;
    public final static int costWide = 35;
    public static String cents2dollarsAndCentsmethod(int cents){
        String dollar = String.valueOf(cents/100);
        return dollar;
    }

}
