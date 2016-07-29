/**
 * Created by Downstairs Better on 9/30/2015.
 */
public interface IReceiptParser {

    Receipt ParseBlock(String in);
    Item ParseLine(String in);
    String GetName(String in);
    String GetPrice(String in);
    boolean HasImported(String in);
    boolean CheckExemptList(String in);
    int GetQuantity(String in);
}
