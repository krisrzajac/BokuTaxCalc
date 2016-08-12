import java.math.BigDecimal;

/**
 * Created by Downstairs Better on 9/30/2015.
 */
public  class Item {
	
    BigDecimal price;
	int quantity;
    String name;
    boolean isImported, isExempt;
    
    public Item()
    {
        price = new BigDecimal(0);
        name = "NA";
        quantity = 1;
        isImported = false;
        isExempt = false;
    }
    
    public Item(String nam, String pric, boolean imported, boolean exempt, int quant)
    {
        name = nam;
        price = new BigDecimal(pric);
        isImported = imported;
        quantity = quant;
        isExempt = exempt;
    }

    public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public boolean isExempt() {
		return isExempt;
	}

	public void setExempt(boolean isExempt) {
		this.isExempt = isExempt;
	}
}
