import junit.framework.TestCase;
import org.junit.Test;
import java.math.BigDecimal;

/**
 * Created by Downstairs Better on 9/30/2015.
 * public Item(String nam, String pric, boolean imported, boolean exempt, int quant)
 */
public class TaxCalculatorTest extends TestCase {
    private static BigDecimal BASERATE = new BigDecimal(10);
    private static BigDecimal IMPORTRATE = new BigDecimal(5);
    private static BigDecimal IMPORTPLUSBASERATE = new BigDecimal(15);
    private static String TESTNAME = "test";

    Item test1 = new Item("book", "12.49", false, true, 1);
    Item test2 = new Item("music CD", "14.99", false, false, 1);
    Item test3 = new Item("chocolate bar", ".85", false, true, 1);


    Receipt rec = new ReceiptParser().ParseBlock("Input 1:\n" +
            "1 book at 12.49\n" +
            "1 music CD at 14.99\n" +
            "1 chocolate bar at 0.85");


    Receipt rec2 = new ReceiptParser().ParseBlock("Input 2:\n" +
            "1 imported box of chocolates at 10.00\n" +
            "1 imported bottle of perfume at 47.50");

    Receipt rec3 = new ReceiptParser().ParseBlock("Input 3:\n" +
            "1 imported bottle of perfume at 27.99\n" +
            "1 bottle of perfume at 18.99\n" +
            "1 packet of headache pills at 9.75\n" +
            "1 box of imported chocolates at 11.25");


    TaxCalculator tc = TaxCalculator.getInstance();



   @org.junit.Test
   public void testTaxCalc()
    {
        assertEquals(tc.CalculateIndividualTax(test1), new BigDecimal("0"));
        assertEquals(tc.CalculateIndividualTax(test2), new BigDecimal("1.50"));
        assertEquals(tc.CalculateIndividualTax(test3), new BigDecimal("0"));

        assertEquals(tc.CalculateTax(rec.receiptList), new BigDecimal("1.50"));



        assertEquals(tc.CalculateTax(rec2.receiptList), new BigDecimal("7.65"));


        assertEquals(tc.CalculateTax(rec3.receiptList), new BigDecimal("6.70"));

    }

}


