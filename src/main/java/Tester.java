import java.math.BigDecimal;

/**
 * Created by Downstairs Better on 9/30/2015.
 */
public class Tester {

    public static void main(String[] args)
    {



//        Basic test class, input through string or STDIN as whole block, output to console

        Receipt rec = new ReceiptParser().ParseBlock("Input 1:\n" +
                "1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85");

        rec.PrintReceipt();

        Receipt rec2 = new ReceiptParser().ParseBlock("Input 2:\n" +
                "1 imported box of chocolates at 10.00\n" +
                "1 imported bottle of perfume at 47.50");
        rec2.PrintReceipt();
        Receipt rec3 = new ReceiptParser().ParseBlock("Input 3:\n" +
                "1 imported bottle of perfume at 27.99\n" +
                "1 bottle of perfume at 18.99\n" +
                "1 packet of headache pills at 9.75\n" +
                "1 box of imported chocolates at 11.25");
        rec3.PrintReceipt();
    }
}
