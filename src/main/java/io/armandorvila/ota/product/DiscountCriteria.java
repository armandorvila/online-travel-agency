package io.armandorvila.ota.product;

public interface DiscountCriteria {

	String name();

	String description();

	boolean apply(Order order);
}
