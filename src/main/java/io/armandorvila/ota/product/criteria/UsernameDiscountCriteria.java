package io.armandorvila.ota.product.criteria;

import io.armandorvila.ota.product.DiscountCriteria;
import io.armandorvila.ota.product.Order;

public class UsernameDiscountCriteria implements DiscountCriteria {

	private static final String DISCOUNT_NAME = "Henk";

	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public boolean apply(Order order) {
		return DISCOUNT_NAME.equals(order.getUser().getName());
	}

	@Override
	public String description() {
		return "Disccount apply to any order placed by a user called Henk";
	}
}
