package io.armandorvila.ota.product;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import lombok.Getter;

public class Order {

	@Getter
	private Long id;

	@Getter
	private LocalDate date;

	@Getter
	private User user;

	@Getter
	private Set<Product> products;

	public void applyDiscounts(DiscountService discountService) {

		products.forEach(product -> {
			List<DiscountCriteria> criterias = discountService.getDiscountCriterias(product);
			criterias.stream().filter(criteria -> criteria.apply(this));
			product.calculatePrice(criterias);
		});
	}
}
