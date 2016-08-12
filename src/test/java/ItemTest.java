import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;


/**
 * Created by Downstairs Better on 9/30/2015.
 */
public class ItemTest extends TestCase {
	Item itemTestEmpty = new Item();
	Item itemTestFull = new Item("Imported book", "12.49",true,true, 1);
	

@Test
public void testItemEmpty ()
{
	
	  assertEquals(new BigDecimal(0), itemTestEmpty.getPrice());
	  assertEquals("NA", itemTestEmpty.getName());
	  assertEquals(1, itemTestEmpty.getQuantity());
	  assertEquals(false, itemTestEmpty.isExempt());
	  assertEquals(false,itemTestEmpty.isImported());
	  
	}
}