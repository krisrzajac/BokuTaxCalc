import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by Downstairs Better on 9/30/2015.
 */
public class TaxCalculator implements ITaxCalculator {


    private static BigDecimal BASERATE = new BigDecimal(10);
    private static BigDecimal IMPORTRATE = new BigDecimal(5);
    private static BigDecimal IMPORTPLUSBASERATE = new BigDecimal(15);

//singleton to be used by other classes
    private static TaxCalculator tc = new TaxCalculator();

    private TaxCalculator(){}

    public static TaxCalculator getInstance()
    {
        return tc;
    }


    /* Calculate Individual tax method -
    * Used to calculate tax on individual items, called within the print receipt function
    * Param - Item to have tax calculated on
    * */
    public BigDecimal CalculateIndividualTax(Item item)
    {
        if(item.isImported && !item.isExempt) {
            return RoundValue(new BigDecimal(item.quantity).multiply(IMPORTPLUSBASERATE.multiply(item.price).divide(new BigDecimal("100"))));
        }
        else if(!item.isExempt)
        {
            return RoundValue(new BigDecimal(item.quantity).multiply(BASERATE.multiply(item.price).divide(new BigDecimal("100"))));
        }
        else if(item.isExempt && item.isImported)
        {
            return RoundValue(new BigDecimal(item.quantity).multiply(IMPORTRATE.multiply(item.price).divide(new BigDecimal("100"))));
        }
        else
        {
            return BigDecimal.ZERO;
        }
    }


/*Calculate Tax on ArrayList method
* Used to calculate tax on all items in an arraylist
* Param - ArrayList of Items to total tax on
* Return -BigDecimal representation of total, after being rounded by Round(BigDecimal)
* */
    public BigDecimal CalculateTax(ArrayList<Item> iList)
    {
        BigDecimal totalTax = new BigDecimal(0);
        for(Item item : iList)
        {

            if(item.isImported && !item.isExempt) {
                    totalTax = totalTax.add(new BigDecimal(item.quantity).multiply(IMPORTPLUSBASERATE.multiply(item.price).divide(new BigDecimal("100"))));
            }
            else if(!item.isExempt)
            {
                totalTax = totalTax.add(new BigDecimal(item.quantity).multiply(BASERATE.multiply(item.price).divide(new BigDecimal("100"))));
            }
            else if(item.isExempt && item.isImported)
            {
                totalTax =totalTax.add(new BigDecimal(item.quantity).multiply(IMPORTRATE.multiply(item.price).divide(new BigDecimal("100"))));
            }
            else
            {

            }
        }
        return RoundValue(totalTax);
    }

    /*Rounding method
    * Rounds up to nearest .05
    * Param - BigDecimal value to be rounded
    * Return - BigDecimal after being rounded
    * */
    public BigDecimal RoundValue(BigDecimal input)
    {
        input = input.multiply(new BigDecimal("20"));
        input = input.setScale(0, RoundingMode.UP).setScale(2);
        return input.divide(new BigDecimal("20"), RoundingMode.UP);
    }
}
