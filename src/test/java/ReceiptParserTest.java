import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Downstairs Better on 9/30/2015.
 */
public class ReceiptParserTest extends TestCase {

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


    @Test
    public void testParser()
    {
        assertEquals(new BigDecimal("12.49"), rec.receiptList.get(0).price);
        assertEquals(new BigDecimal("14.99"), rec.receiptList.get(1).price);
        assertEquals(new BigDecimal("0.85"), rec.receiptList.get(2).price);

        assertEquals(new BigDecimal("10.00"), rec2.receiptList.get(0).price);
        assertEquals(new BigDecimal("47.50"), rec2.receiptList.get(1).price);

        assertEquals(new BigDecimal("27.99"), rec3.receiptList.get(0).price);
        assertEquals(new BigDecimal("18.99"), rec3.receiptList.get(1).price);
        assertEquals(new BigDecimal("9.75"), rec3.receiptList.get(2).price);
        assertEquals(new BigDecimal("11.25"), rec3.receiptList.get(3).price);

        assertEquals("book", rec.receiptList.get(0).name);
        assertEquals("music CD", rec.receiptList.get(1).name);
        assertEquals("chocolate bar", rec.receiptList.get(2).name);

        assertEquals("imported box of chocolates", rec2.receiptList.get(0).name);
        assertEquals("imported bottle of perfume", rec2.receiptList.get(1).name);

        assertEquals("imported bottle of perfume", rec3.receiptList.get(0).name);
        assertEquals("bottle of perfume", rec3.receiptList.get(1).name);
        assertEquals("packet of headache pills", rec3.receiptList.get(2).name);
        assertEquals("box of imported chocolates", rec3.receiptList.get(3).name);

        assertEquals(false, rec.receiptList.get(0).isImported);
        assertEquals(false, rec.receiptList.get(1).isImported);
        assertEquals(false, rec.receiptList.get(2).isImported);

        assertEquals(true, rec2.receiptList.get(0).isImported);
        assertEquals(true, rec2.receiptList.get(1).isImported);

        assertEquals(true, rec3.receiptList.get(0).isImported);
        assertEquals(false, rec3.receiptList.get(1).isImported);
        assertEquals(false, rec3.receiptList.get(2).isImported);
        assertEquals(true, rec3.receiptList.get(3).isImported);

        assertEquals(true, rec.receiptList.get(0).isExempt);
        assertEquals(false, rec.receiptList.get(1).isExempt);
        assertEquals(true, rec.receiptList.get(2).isExempt);

        assertEquals(true, rec2.receiptList.get(0).isExempt);
        assertEquals(false, rec2.receiptList.get(1).isExempt);

        assertEquals(false, rec3.receiptList.get(0).isExempt);
        assertEquals(false, rec3.receiptList.get(1).isExempt);
        assertEquals(true, rec3.receiptList.get(2).isExempt);
        assertEquals(true, rec3.receiptList.get(3).isExempt);

    }
}