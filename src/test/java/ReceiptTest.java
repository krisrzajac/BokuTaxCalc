import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Downstairs Better on 9/30/2015.
 * public Item(String nam, String pric, boolean imported, boolean exempt, int quant)
 */
public class ReceiptTest extends TestCase {

    Receipt rec = new ReceiptParser().ParseBlock("Input 1:\n" +
            "1 book at 12.49\n" +
            "1 music CD at 14.99\n" +
            "1 chocolate bar at 0.85");



@Test
    public void testReceipt()
{
    assertEquals("book", rec.receiptList.get(0).name);
    assertEquals("music CD", rec.receiptList.get(1).name);
    assertEquals("chocolate bar", rec.receiptList.get(2).name);

    assertEquals(new BigDecimal("12.49"), rec.receiptList.get(0).price);
    assertEquals(new BigDecimal("14.99"), rec.receiptList.get(1).price);
    assertEquals(new BigDecimal("0.85"), rec.receiptList.get(2).price);

    assertEquals(true, rec.receiptList.get(0).isExempt);
    assertEquals(false, rec.receiptList.get(1).isExempt);
    assertEquals(true, rec.receiptList.get(2).isExempt);

    assertEquals(false, rec.receiptList.get(0).isImported);
    assertEquals(false, rec.receiptList.get(1).isImported);
    assertEquals(false, rec.receiptList.get(2).isImported);


}
}