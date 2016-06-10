/**
 * 
 */
package com.mahesh.tax.calculator.domain;

/**
 * @author maheshd
 *
 */
public class CartItem
{

	private int quantity;
	private Item item;

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public Item getItem()
	{
		return item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

}
