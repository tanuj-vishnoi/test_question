package pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PriceCheck {

	
	
	public static void main(String...a) {
		List<String> products = new ArrayList<String>() ;
		products.add("eggs");products.add("milk");products.add("cheese");
		
		//float[] price = {2.89f, 3.29f, 5.79f};
		List<Float> price = new ArrayList<Float>() ;
		price.add(2.89f);price.add(3.29f);
		price.add(5.79f);
		List<String> soldItems = new ArrayList<String>() ;
		soldItems.add("eggs");soldItems.add("eggs");soldItems.add("cheese");soldItems.add("milk");
		
		List<Float> soldPrice = new ArrayList<Float>() ;
		soldPrice.add(2.89f);soldPrice.add(2.99f);
		soldPrice.add(5.97f);soldPrice.add(3.29f);
		System.out.println(priceCheck(products, price, soldItems, soldPrice));
	}
	
	public static int priceCheck(List<String> products, List<Float> price,
							List<String> solItems, List<Float> soldPrice) {
		int count = 0;
		Map<String,Float> inventory = new HashMap<String,Float>();
		for(int i =0 ;i < products.size() ; i++) {
			inventory.put(products.get(i), price.get(i));
		}
		Map<String,List<Float>> soldInventory = new HashMap<String,List<Float>>();
		
		for(int i =0 ;i < solItems.size() ; i++) {
			if(soldInventory.containsKey(solItems.get(i))) {
				List<Float> p = soldInventory.get(solItems.get(i));
				p.add(soldPrice.get(i));
				soldInventory.put(solItems.get(i), p);
			}else {
				List<Float> list = new ArrayList<Float>();
				list.add(soldPrice.get(i));
				soldInventory.put(solItems.get(i), list);
			}
				
		}
		  for (Map.Entry<String, List<Float>> map : soldInventory.entrySet()) {
			  String soldProduct = map.getKey();
			  List<Float> prices = map.getValue();
			  Float originalPrice = inventory.get(soldProduct);
			  for(Float f : prices) {
				 if(Float.floatToIntBits(f) == Float.floatToIntBits(originalPrice))
					 continue;
					 else
					  count++;
			  }
			
		}
	
		
		
		return count;
	}
}
