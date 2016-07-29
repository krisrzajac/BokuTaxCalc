import java.math.BigDecimal;

/**
 * Created by Downstairs Better on 9/30/2015.
 */
public  class Item {
    BigDecimal price;
    int quantity;
    String name;

    boolean isImported, isExempt;
    public Item()
    {
        price = new BigDecimal(0);
        name = "";
        quantity = 1;
        isImported = false;
        isExempt = false;
    }

    public Item(String nam, String pric, boolean imported, boolean exempt, int quant)
    {
        name = nam;
        price = new BigDecimal(pric);
        isImported = imported;
        quantity = quant;
        isExempt = exempt;
    }


}
