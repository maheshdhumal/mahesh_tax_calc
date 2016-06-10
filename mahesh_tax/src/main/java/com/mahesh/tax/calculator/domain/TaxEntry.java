/**
 * 
 */
package com.mahesh.tax.calculator.domain;

/**
 * @author maheshd
 *
 */
public class TaxEntry
{

	
	private String category;
	private double salesTax;
	private double importDuty;
	private String itemName;
	
	
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public double getSalesTax()
	{
		return salesTax;
	}
	public void setSalesTax(double salesTax)
	{
		this.salesTax = salesTax;
	}
	public double getImportDuty()
	{
		return importDuty;
	}
	public void setImportDuty(double importDuty)
	{
		this.importDuty = importDuty;
	}
	public String getItemName()
	{
		return itemName;
	}
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	
	
	
}
