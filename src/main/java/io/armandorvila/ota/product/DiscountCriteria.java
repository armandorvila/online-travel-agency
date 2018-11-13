package io.armandorvila.ota.product;

public interface DiscountCriteria {

	String name();

	String description();

	/**
	 * Decided if a discount criteria applies to an order.
	 * 
	 * @param order order to evaluate the discount for
	 * @return true if the discount apply to this order.
	 * 
	 * <p> NOTE: If we want to define also criteria(s) for another type of entity we can make this interface generic: DiscountCriteria<T> </p> 
	 */
	boolean apply(Order order);
}
