/**
 * 
 */
package com.mahesh.tax.calculator.service;

import java.util.List;
import com.mahesh.tax.calculator.domain.CartItem;
import com.mahesh.tax.calculator.domain.Reciept;

/**
 * @author maheshd
 *
 */
public interface RecieptService
{

	Reciept createReciept(List<CartItem> cartItems);
}
