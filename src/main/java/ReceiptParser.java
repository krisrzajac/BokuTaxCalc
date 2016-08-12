
public class ReceiptParser {
    Receipt rec;
    String input;
    private static String PATTERN_AT ="at";
    private static String PATTERN_NEWLINE = "\n";
    private static char PATTERN_SPACE = ' ';

    private static String[] EXEMPT_WORDS = {"book", "chocolate", "pill"};

    public ReceiptParser()
    {
        rec = new Receipt();



    }

    /*Parser used to parse full block of text, copied from Coding Challenge Worksheet
    * Param - String representation of input, including newline characters
    * Return - Receipt object, member ArrayList populated with items parsed from input
    * */
    public Receipt ParseBlock(String in)
    {
        String[] splitArray = in.split(PATTERN_NEWLINE);
        for(int i =1;i<splitArray.length;i++) {
            rec.AddItem(ParseLine(splitArray[i]));
        }
        return rec;
    }

    /*Parser used to parse single line of text, used by ParseBlock method after splitting input into lines
    * Param - String representation of single line of input
    * Return - Item to be placed into ArrayList member of Receipt returned by ParseBlock(..)
    * */
    public Item ParseLine(String in)
    {
    	
        return new Item(
                GetName(in),
                GetPrice(in),
                HasImported(in),
                CheckExemptList(in),
                GetQuantity(in));
    }

    /*GetName method pulls name of item from a line of text
    * Param - String representation of single line of input
    * Return - String representation of name to be added to Item object
    * */

public String GetName(String in)
{
	
    return  in.substring(in.indexOf(PATTERN_SPACE)+1,
            in.lastIndexOf(PATTERN_AT)-1);
}


    /*GetPrice method pulls price of item from a line of text
    * Param -  String representation of single line of input
    * Return - String representation of price to be added to Item object
    * */

    public String GetPrice(String in)
    {
        return  in.substring(in.lastIndexOf(PATTERN_AT)+3, in.length());
    }


    /*HasImported uses String.contains to test for imported keyword
    * Param -  String representation of single line of input
    * Return - true or false depending on whether item is an Import
    * */
    public boolean HasImported(String in)
    {
        return in.contains("imported");
    }



    /*CheckExempList method checks against Exempt List from provided input
    * Param - String representation of single line of input
    * Return - true or false depending on whether item is exempt from tax
    * */
    public boolean CheckExemptList(String in)
    {
        for(String s: EXEMPT_WORDS)
        {
            if(in.contains(s))
                return true;
        }
        return false;
    }


    /*GetQuantity method splits input line by space and takes first item, the quantity
    * Param -  String representation of single line of input
    * Return - Quantity of items given
    * */
    public int GetQuantity(String in)
    {
       return Integer.parseInt(in.split(" ")[0].trim());
    }
}
