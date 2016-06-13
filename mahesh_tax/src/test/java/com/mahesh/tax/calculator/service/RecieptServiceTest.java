/**
 * 
 */
package com.mahesh.tax.calculator.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mahesh.tax.calculator.TaxApplication;
import com.mahesh.tax.calculator.domain.CartItem;
import com.mahesh.tax.calculator.domain.Item;
import com.mahesh.tax.calculator.domain.Reciept;

/**
 * @author maheshd
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TaxApplication.class)
public class RecieptServiceTest
{
	@Autowired
	RecieptService recieptService;
	
	
	@Test
	public void testCreateReciept()
	{
		List<CartItem> cartItems=new ArrayList<CartItem> ();
		CartItem cartItem=new CartItem();
		Item item=new Item();
		item.setName("chocolate");
		item.setPrice(10d);
		item.setImported(true);
		cartItem.setItem(item);
		cartItem.setQuantity(2);
		cartItems.add(cartItem);
		Reciept reciept=recieptService.createReciept(cartItems);
		for(CartItem cartItem2:reciept.getCartItems())
		{
			System.out.println("item :"+cartItem2.getItem().getName() +" "+cartItem2.getItem().getPrice() +" * "+cartItem2.getQuantity());
		}
		System.out.println("Total Tax :"+reciept.getTotalTax());
		System.out.println("Total Cost :"+reciept.getTotalCost());
	}
	
}
