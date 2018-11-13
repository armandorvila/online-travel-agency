package io.armandorvila.ota.product;

import java.util.List;

public interface DiscountService {

	/**
	 * Retrieves the list of criteria(s) defined for an specific product, for example from the database, or from 
	 * another service....
	 */
	List<DiscountCriteria> getDiscountCriterias(Product product);
}
