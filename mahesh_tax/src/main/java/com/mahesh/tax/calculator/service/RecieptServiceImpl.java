/**
 * 
 */
package com.mahesh.tax.calculator.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mahesh.tax.calculator.domain.CartItem;
import com.mahesh.tax.calculator.domain.Reciept;

/**
 * @author maheshd
 *
 */
@Service
public class RecieptServiceImpl implements RecieptService
{
	@Autowired
	private TaxService taxService;
	
	
	public void setTaxService(TaxService taxService)
	{
		this.taxService = taxService;
	}
	
	@Override
	public Reciept createReciept(List<CartItem> cartItems)
	{
		Reciept reciept=new Reciept();
		for(CartItem cartItem:cartItems)
		{
			cartItem.setItem(taxService.calculateTaxForItem(cartItem.getItem()));	
		}
		reciept.setTotalCost(getTotalCost(cartItems));
		reciept.setTotalTax(taxService.getTotalTax(cartItems));
		reciept.setCartItems(cartItems);
		return reciept;
	}

	private double getTotalCost(List<CartItem> cartItems)
	{
		double totalTax = taxService.getTotalTax(cartItems);
		double totalCostWithOutTax = cartItems.stream().mapToDouble(i -> (i.getItem().getPrice() * i.getQuantity())).sum();
		double totalCost= totalCostWithOutTax + totalTax;
		return totalCost;
	}

	


}
