package com.mahesh.tax.calculator.service;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.mahesh.tax.calculator.domain.CartItem;
import com.mahesh.tax.calculator.domain.Item;

@Service
public class TaxServiceImpl implements TaxService
{

	
	@PostConstruct
	public void init()
	{
		TaxServiceCache.addTaxChartToCache();
	}
	
	@Override
	public Item calculateTaxForItem(Item item)
	{
		Double totalTaxOnItem = 0d;
		Double salesTaxRate = TaxServiceCache.getSalesTaxRate(item);
		totalTaxOnItem = (salesTaxRate * item.getPrice()) / 100;
		if (item.isImported())
		{
			Double importDutyRate = TaxServiceCache.getImportDutyRate(item);
			totalTaxOnItem = totalTaxOnItem + ((importDutyRate * item.getPrice()) / 100);
		}
		item.setTax(totalTaxOnItem);
		return item;
	}

	@Override
	public double getTotalTax(List<CartItem> cartItems)
	{
		return cartItems.stream().mapToDouble(i -> (i.getItem().getTax() * i.getQuantity())).sum();
	}
	
	

}
