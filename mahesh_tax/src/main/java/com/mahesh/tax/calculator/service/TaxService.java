/**
 * 
 */
package com.mahesh.tax.calculator.service;

import java.util.List;
import com.mahesh.tax.calculator.domain.CartItem;
import com.mahesh.tax.calculator.domain.Item;

/**
 * @author maheshd
 *
 */
public interface TaxService
{

	Item calculateTaxForItem(Item item);

	double getTotalTax(List<CartItem> cartItems);
}
