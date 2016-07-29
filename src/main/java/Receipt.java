import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Downstairs Better on 9/30/2015.
 */
public class Receipt implements IItemBasket {
    private int size;
     ArrayList<Item> receiptList;
    private TaxCalculator calc = TaxCalculator.getInstance();
    public Receipt()
    {
        receiptList = new ArrayList<Item>();
        size = 0;

    }
    public void AddItem(Item i)
    {
        receiptList.add(i);
    }

    public void PrintReceipt()
    {
        BigDecimal total = new BigDecimal(0);

        for(Item listItem : receiptList) {
            System.out.println(listItem.quantity + " " + listItem.name + " : " + listItem.price.add(calc.CalculateIndividualTax(listItem)));
            System.out.println();
            total = total.add(listItem.price);
        }
        System.out.println("Pretax Total : " + total);
        System.out.println("Sales Taxes : " + calc.CalculateTax(receiptList));
        System.out.println("Total : " + calc.CalculateTax(receiptList).add(total));

    }
}
