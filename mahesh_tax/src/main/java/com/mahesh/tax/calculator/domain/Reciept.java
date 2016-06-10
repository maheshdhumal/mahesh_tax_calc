/**
 * 
 */
package com.mahesh.tax.calculator.domain;

import java.util.List;

/**
 * @author maheshd
 *
 */
public class Reciept
{

	private Double recieptNo;
	private List<CartItem> cartItems;
	private Double totalTax;
	private Double totalCost;
	
	
	public Double getRecieptNo()
	{
		return recieptNo;
	}
	public void setRecieptNo(Double recieptNo)
	{
		this.recieptNo = recieptNo;
	}
	public List<CartItem> getCartItems()
	{
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems)
	{
		this.cartItems = cartItems;
	}
	public Double getTotalTax()
	{
		return totalTax;
	}
	public void setTotalTax(Double totalTax)
	{
		this.totalTax = totalTax;
	}
	public Double getTotalCost()
	{
		return totalCost;
	}
	public void setTotalCost(Double totalCost)
	{
		this.totalCost = totalCost;
	}
	
	
	

	
	
}
