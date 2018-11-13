package io.armandorvila.ota.product;

import java.util.List;

public interface DiscountService {

	List<DiscountCriteria> getDiscountCriterias(Product product);
}
