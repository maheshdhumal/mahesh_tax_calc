/**
 * 
 */
package com.mahesh.tax.calculator.domain;


/**
 * @author maheshd
 *
 */
public class Item
{
	private String name;
	private Double price;
	private Double tax;
	private boolean isImported;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Double getPrice()
	{
		return price;
	}
	
	public void setPrice(Double price)
	{
		this.price = price;
	}
	
	public Double getTax()
	{
		return tax;
	}
	public void setTax(Double totalTaxOnItem)
	{
		this.tax = totalTaxOnItem;
	}
	
	public boolean isImported()
	{
		return isImported;
	}

	public void setImported(boolean isImported)
	{
		this.isImported = isImported;
	}
}
