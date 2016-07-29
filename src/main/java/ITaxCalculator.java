import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Downstairs Better on 9/30/2015.
 */
public interface ITaxCalculator {
    BigDecimal CalculateIndividualTax(Item item);
    BigDecimal CalculateTax(ArrayList<Item> iList);
    BigDecimal RoundValue(BigDecimal input);
}
