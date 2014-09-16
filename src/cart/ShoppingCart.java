package cart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
	private double total_amount;
	private double total_quantity;
	private boolean has_items;
	
	private static final Logger logger = LogManager.getLogger(ShoppingCart.class);
	
	private Map<Integer,CartLineItem> items = new HashMap<Integer,CartLineItem>();
	
	public void add(int id, String type, double price){
		CartLineItem lineItem = null;
		if (items.containsKey(id)){
			lineItem = items.get(id);
			lineItem.incrementQuantity();
			logger.debug("found id: " + id + " type: " + type + " increased quantity");
		}
		else{
			lineItem = new CartLineItem();
			lineItem.setId(id);
			lineItem.setType(type);
			lineItem.setPrice(price);
			items.put(id,lineItem);
			logger.debug("added id: " + id + " type: " + type);
		}
		this.total_amount += lineItem.getPrice();
		this.total_quantity++;
		if(total_amount>0){
			has_items = true;
		}
	}
	
	public double getTotalAmount() {
		return total_amount;
	}

	public double getTotalQuantity() {
		return total_quantity;
	}
	
	public boolean cartHasItems(){
		return has_items;
	}

	public Iterator<CartLineItem> getIterator(){
		return items.values().iterator();
	}

	public void remove(int id, String type, double price) {
		CartLineItem lineItem = null;
		// only decrement if found to prevent hacking through URL and getting negative amounts
		if (items.containsKey(id)){
			lineItem = items.get(id);
			lineItem.decrementQuantity();
			this.total_quantity--;
			this.total_amount -= lineItem.getPrice();
			logger.debug("found id: " + id + " type: " + type + " decreased quantity");
			if(lineItem.getQuantity()==0){
				items.remove(id);
			}
			if(total_amount==0){
				has_items = false;
			}
		}
	}
	
}

